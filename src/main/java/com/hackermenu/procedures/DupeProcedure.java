package com.hackermenu.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class DupeProcedure {
    public static void execute(Entity entity) {
        if (entity == null || !(entity instanceof PlayerEntity player)) return;

        for (int slotIndex = 0; slotIndex < 9; slotIndex++) {
            Slot slot = player.currentScreenHandler.getSlot(slotIndex);
            ItemStack stack = slot.getStack();
            if (!stack.isEmpty()) {
                ItemStack copy = stack.copy();
                copy.setCount(stack.getCount());
                slot.setStack(copy);
            }
        }
    }
}
