package com.hackermenu.client.gui;

import com.hackermenu.world.inventory.PotionguiMenu;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ImageButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PotionguiScreen extends HandledScreen<PotionguiMenu> {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/potiongui.png");

    public PotionguiScreen(PotionguiMenu handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        int x = this.x;
        int y = this.y;

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(0, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 6, y + 34, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine1"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(1, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 92, y + 34, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine2"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(2, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 92, y + 61, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine3"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(3, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 92, y + 88, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine4"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(4, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 6, y + 61, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine5"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(5, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 6, y + 88, 77, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine6"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.PotionguiButtonMessage.sendToServer(6, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 51, y + 124, 77, 20).build());

        addDrawableChild(new ImageButtonWidget(x + 150, y + 7, 16, 16, 0, 0, 0,
                Identifier.of("hackermenu", "textures/gui/forward.png"), 16, 16,
                btn -> {
                    if (client != null && client.player != null) {
                        com.hackermenu.network.PotionguiButtonMessage.sendToServer(7, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
                    }
                }));
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.potiongui.label_potion_page"), 60, 151, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.potiongui.label_back"), 121, 11, -12829636, false);
    }
}
