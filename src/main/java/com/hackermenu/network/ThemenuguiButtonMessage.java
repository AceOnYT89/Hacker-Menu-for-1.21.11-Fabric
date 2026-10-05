package com.hackermenu.network;

import com.hackermenu.procedures.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public record ThemenuguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPayload {
    public static final Id<ThemenuguiButtonMessage> ID = new Id<>(Identifier.of("hackermenu", "themenugui_buttons"));
    public static final PacketCodec<PacketByteBuf, ThemenuguiButtonMessage> CODEC = PacketCodec.tuple(
            PacketCodec.VAR_INT,
            ThemenuguiButtonMessage::buttonID,
            PacketCodec.VAR_INT,
            ThemenuguiButtonMessage::x,
            PacketCodec.VAR_INT,
            ThemenuguiButtonMessage::y,
            PacketCodec.VAR_INT,
            ThemenuguiButtonMessage::z,
            ThemenuguiButtonMessage::new
    );

    public static void register() {
        PayloadTypeRegistry.playC2S().register(ID, CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> handleButtonAction(player, payload.buttonID(), payload.x(), payload.y(), payload.z()));
        });
    }

    public static void sendToServer(int buttonID, int x, int y, int z) {
        ClientPlayNetworking.send(new ThemenuguiButtonMessage(buttonID, x, y, z));
    }

    public static void handleButtonAction(ServerPlayerEntity entity, int buttonID, int x, int y, int z) {
        if (entity == null) return;
        if (entity.getWorld().isChunkLoaded(entity.getBlockPos())) {
            if (buttonID == 0) SurvivalProcedure.execute(entity);
            if (buttonID == 1) CreativeProcedure.execute(entity);
            if (buttonID == 2) SpectatorProcedure.execute(entity);
            if (buttonID == 3) Xp5Procedure.execute(entity);
            if (buttonID == 4) Xp10Procedure.execute(entity);
            if (buttonID == 5) Xp50Procedure.execute(entity);
            if (buttonID == 6) XpMAXProcedure.execute(entity);
            if (buttonID == 7) DupeProcedure.execute(entity);
            if (buttonID == 8) RemoveallProcedure.execute(entity);
            if (buttonID == 9) SemigodProcedure.execute(entity.getWorld(), x, y, z);
            if (buttonID == 10) Button2GUICommandProcedure.execute(entity.getWorld(), x, y, z, entity);
            if (buttonID == 11) Button2GUIPotionProcedure.execute(entity.getWorld(), x, y, z, entity);
        }
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
