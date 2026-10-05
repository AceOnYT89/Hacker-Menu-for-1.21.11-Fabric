package com.hackermenu.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.WorldAccess;

public class Button2GUICommandProcedure {
    public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
        if (entity != null && entity instanceof ServerPlayerEntity player) {
            player.openHandledScreen(new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.literal("CommandGUI");
                }

                @Override
                public ScreenHandler createMenu(int syncId, net.minecraft.entity.player.PlayerInventory inv, net.minecraft.entity.player.PlayerEntity player) {
                    return new com.hackermenu.world.inventory.CommandGUIMenu(syncId, inv);
                }
            });
        }
    }
}
