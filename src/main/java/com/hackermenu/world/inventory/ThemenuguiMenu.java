package com.hackermenu.world.inventory;

import com.hackermenu.init.HackermenuModMenus;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ThemenuguiMenu extends ScreenHandler {
    public static final java.util.HashMap<String, Object> guistate = new java.util.HashMap<>();
    public int x;
    public int y;
    public int z;

    public ThemenuguiMenu(int syncId, PlayerInventory inv) {
        super(HackermenuModMenus.THEMENUGUI, syncId);

        this.addSlot(new Slot(new Inventory(9), 0, 123, 8));
        this.addSlot(new Slot(new Inventory(9), 1, 141, 8));
        this.addSlot(new Slot(new Inventory(9), 2, 159, 8));
        this.addSlot(new Slot(new Inventory(9), 3, 123, 26));
        this.addSlot(new Slot(new Inventory(9), 4, 141, 26));
        this.addSlot(new Slot(new Inventory(9), 5, 159, 26));
        this.addSlot(new Slot(new Inventory(9), 6, 123, 44));
        this.addSlot(new Slot(new Inventory(9), 7, 141, 44));
        this.addSlot(new Slot(new Inventory(9), 8, 159, 44));

        for (int si = 0; si < 3; ++si) {
            for (int sj = 0; sj < 9; ++sj) {
                this.addSlot(new Slot(inv, sj + (si + 1) * 9, 70 + sj * 18, 87 + si * 18));
            }
        }
        for (int si = 0; si < 9; ++si) {
            this.addSlot(new Slot(inv, si, 70 + si * 18, 145));
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
