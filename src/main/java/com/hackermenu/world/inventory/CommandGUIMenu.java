package com.hackermenu.world.inventory;

import com.hackermenu.init.HackermenuModMenus;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CommandGUIMenu extends ScreenHandler {
    public static final java.util.HashMap<String, Object> guistate = new java.util.HashMap<>();
    public int x;
    public int y;
    public int z;

    public CommandGUIMenu(int syncId, PlayerInventory inv) {
        super(HackermenuModMenus.COMMAND_GUI, syncId);
        for (int si = 0; si < 3; ++si) {
            for (int sj = 0; sj < 9; ++sj) {
                this.addSlot(new Slot(new Inventory(9), sj + si * 9, 8 + sj * 18, 84 + si * 18));
            }
        }
        for (int si = 0; si < 9; ++si) {
            this.addSlot(new Slot(new Inventory(9), si, 8 + si * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        return ItemStack.EMPTY;
    }
}
