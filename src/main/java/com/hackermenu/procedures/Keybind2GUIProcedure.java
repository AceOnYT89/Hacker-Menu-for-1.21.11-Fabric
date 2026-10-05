package com.hackermenu.procedures;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class Keybind2GUIProcedure {
    public static void execute(WorldAccess world, double x, double y, double z, Entity entity) {
        if (entity != null && entity instanceof ServerPlayerEntity player) {
            BlockPos pos = BlockPos.ofFloored(x, y, z);
            player.openHandledScreen(new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.literal("Themenugui");
                }

                @Override
                public ScreenHandler createMenu(int syncId, net.minecraft.entity.player.PlayerInventory inv, PlayerEntity player) {
                    return new com.hackermenu.world.inventory.ThemenuguiMenu(syncId, inv);
                }
            });
        }
    }
}
