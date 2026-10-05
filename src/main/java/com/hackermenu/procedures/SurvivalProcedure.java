package com.hackermenu.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class SurvivalProcedure {
    public static void execute(Entity entity) {
        if (entity != null && entity instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.changeGameMode(GameMode.SURVIVAL);
        }
    }
}
