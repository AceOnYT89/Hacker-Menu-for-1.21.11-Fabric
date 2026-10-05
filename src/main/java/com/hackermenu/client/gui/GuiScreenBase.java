package com.hackermenu.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderPipelines;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class GuiScreenBase extends Screen {
    protected GuiScreenBase(Text title) { super(title); }

    protected void drawCenteredTexture(DrawContext context, Identifier texture, int w, int h) {
        int x = (this.width - w) / 2;
        int y = (this.height - h) / 2;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, texture, x, y, 0, 0, w, h, w, h);
    }
}
