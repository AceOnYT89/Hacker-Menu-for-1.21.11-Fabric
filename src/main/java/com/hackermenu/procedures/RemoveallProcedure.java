package com.hackermenu.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class RemoveallProcedure {
    public static void execute(Entity entity) {
        if (entity != null && entity instanceof LivingEntity livingEntity) {
            livingEntity.removeStatusEffects();
        }
    }
}
