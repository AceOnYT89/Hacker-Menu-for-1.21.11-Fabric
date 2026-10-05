package net.bennysmith.hackermenu.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class GuiScreenBase {
    public static void drawTexture(DrawContext context, Identifier texture, int x, int y, int w, int h) {
        // Standard 1.21.11 texture drawing
        context.drawTexture(texture, x, y, 0, 0, w, h, w, h);
    }
}
