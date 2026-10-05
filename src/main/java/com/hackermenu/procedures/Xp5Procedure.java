package com.hackermenu.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class Xp5Procedure {
    public static void execute(Entity entity) {
        if (entity != null && entity instanceof PlayerEntity player) {
            player.addExperienceLevels(5);
        }
    }
}
