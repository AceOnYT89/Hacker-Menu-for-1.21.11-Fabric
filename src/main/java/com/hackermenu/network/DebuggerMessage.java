package com.hackermenu.network;

import com.hackermenu.HackermenuMod;
import com.hackermenu.procedures.Keybind2GUIProcedure;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public record DebuggerMessage(int eventType, int pressedms) implements CustomPayload {
    public static final Id<DebuggerMessage> ID = new Id<>(Identifier.of("hackermenu", "key_debugger"));
    public static final PacketCodec<PacketByteBuf, DebuggerMessage> CODEC = PacketCodec.tuple(
            PacketCodec.VAR_INT,
            DebuggerMessage::eventType,
            PacketCodec.VAR_INT,
            DebuggerMessage::pressedms,
            DebuggerMessage::new
    );

    public static void register() {
        PayloadTypeRegistry.playC2S().register(ID, CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> {
                if (player.getWorld().isChunkLoaded(player.getBlockPos()) && payload.eventType() == 0) {
                    Keybind2GUIProcedure.execute(player.getWorld(), player.getX(), player.getY(), player.getZ(), player);
                }
            });
        });
    }

    public static void sendToServer(int eventType, int pressedms) {
        ClientPlayNetworking.send(new DebuggerMessage(eventType, pressedms));
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
