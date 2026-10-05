package com.hackermenu.network;

import com.hackermenu.HackermenuMod;
import com.hackermenu.procedures.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public record PotionguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPayload {
    public static final Id<PotionguiButtonMessage> ID = new Id<>(Identifier.of("hackermenu", "potiongui_buttons"));
    public static final PacketCodec<PacketByteBuf, PotionguiButtonMessage> CODEC = PacketCodec.tuple(
            PacketCodec.VAR_INT,
            PotionguiButtonMessage::buttonID,
            PacketCodec.VAR_INT,
            PotionguiButtonMessage::x,
            PacketCodec.VAR_INT,
            PotionguiButtonMessage::y,
            PacketCodec.VAR_INT,
            PotionguiButtonMessage::z,
            PotionguiButtonMessage::new
    );

    public static void register() {
        PayloadTypeRegistry.playC2S().register(ID, CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> handleButtonAction(player, payload.buttonID(), payload.x(), payload.y(), payload.z()));
        });
    }

    public static void sendToServer(int buttonID, int x, int y, int z) {
        ClientPlayNetworking.send(new PotionguiButtonMessage(buttonID, x, y, z));
    }

    public static void handleButtonAction(ServerPlayerEntity entity, int buttonID, int x, int y, int z) {
        if (entity == null) return;
        if (entity.getWorld().isChunkLoaded(entity.getBlockPos())) {
            if (buttonID == 0) HasteProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 1) SaturationProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 2) NightvisionProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 3) InvisibilityProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 4) StrengthProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 5) PoseidonProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 6) RemoveallProcedure.execute(entity);
            if (buttonID == 7) Keybind2GUIProcedure.execute(entity.getWorld(), x, y, z, entity);
        }
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
