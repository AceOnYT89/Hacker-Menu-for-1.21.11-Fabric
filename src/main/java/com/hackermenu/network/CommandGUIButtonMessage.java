package com.hackermenu.network;

import com.hackermenu.procedures.BypasscommandsProcedure;
import com.hackermenu.procedures.Keybind2GUIProcedure;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public record CommandGUIButtonMessage(int buttonID, int x, int y, int z, String commandText) implements CustomPayload {
    public static final Id<CommandGUIButtonMessage> ID = new Id<>(Identifier.of("hackermenu", "command_gui_buttons"));
    public static final PacketCodec<PacketByteBuf, CommandGUIButtonMessage> CODEC = PacketCodec.tuple(
            PacketCodec.VAR_INT,
            CommandGUIButtonMessage::buttonID,
            PacketCodec.VAR_INT,
            CommandGUIButtonMessage::x,
            PacketCodec.VAR_INT,
            CommandGUIButtonMessage::y,
            PacketCodec.VAR_INT,
            CommandGUIButtonMessage::z,
            PacketCodec.STRING,
            CommandGUIButtonMessage::commandText,
            CommandGUIButtonMessage::new
    );

    public static void register() {
        PayloadTypeRegistry.playC2S().register(ID, CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> handleButtonAction(player, payload.buttonID(), payload.x(), payload.y(), payload.z(), payload.commandText()));
        });
    }

    public static void sendToServer(int buttonID, int x, int y, int z, String commandText) {
        ClientPlayNetworking.send(new CommandGUIButtonMessage(buttonID, x, y, z, commandText));
    }

    public static void handleButtonAction(ServerPlayerEntity entity, int buttonID, int x, int y, int z, String commandText) {
        if (entity == null) return;
        if (entity.getWorld().isChunkLoaded(entity.getBlockPos())) {
            if (buttonID == 0) {
                BypasscommandsProcedure.execute(entity.getWorld(), x, y, z, commandText);
            }
            if (buttonID == 1) {
                Keybind2GUIProcedure.execute(entity.getWorld(), x, y, z, entity);
            }
        }
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
