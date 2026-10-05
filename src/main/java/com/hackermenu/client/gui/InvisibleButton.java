package com.hackermenu.client.gui;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class InvisibleButton extends ButtonWidget {
    public InvisibleButton(int x, int y, int width, int height, Runnable action) {
        super(x, y, width, height, Text.empty(), button -> action.run(), DEFAULT_NARRATION_SUPPLIER);
        setAlpha(0.0F);
    }
}
