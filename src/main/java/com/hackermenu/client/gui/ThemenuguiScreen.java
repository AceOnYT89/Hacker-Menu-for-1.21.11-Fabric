package com.hackermenu.client.gui;

import com.hackermenu.world.inventory.ThemenuguiMenu;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ImageButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ThemenuguiScreen extends HandledScreen<ThemenuguiMenu> {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/themenugui.png");

    public ThemenuguiScreen(ThemenuguiMenu handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 300;
        this.backgroundHeight = 173;
    }

    public ThemenuguiScreen() {
        this(new ThemenuguiMenu(0, null), null, Text.translatable("screen.hackermenu.theme"));
    }

    @Override
    protected void init() {
        super.init();
        int x = this.x;
        int y = this.y;

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(0, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 5, y + 86, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva1"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(1, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 5, y + 106, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva2"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(2, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 5, y + 126, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva3"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(3, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 233, y + 84, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva4"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(4, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 233, y + 104, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva5"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(5, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 233, y + 124, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva6"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(6, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 233, y + 144, 61, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(7, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 134, y + 64, 30, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty2"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(8, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 35, y + 44, 25, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty1"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(9, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
            }
        }).dimensions(x + 10, y + 44, 25, 20).build());

        addDrawableChild(new ImageButtonWidget(x + 281, y + 4, 16, 16, 0, 0, 0,
                Identifier.of("hackermenu", "textures/gui/forward.png"), 16, 16,
                btn -> {
                    if (client != null && client.player != null) {
                        com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(10, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
                    }
                }));

        addDrawableChild(new ImageButtonWidget(x + 4, y + 4, 16, 16, 0, 0, 0,
                Identifier.of("hackermenu", "textures/gui/potion_page.png"), 16, 16,
                btn -> {
                    if (client != null && client.player != null) {
                        com.hackermenu.network.ThemenuguiButtonMessage.sendToServer(11, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());
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
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_next_page"), 207, 7, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_hacker_menu_v4"), 5, 162, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_potion_page"), 32, 7, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_semigod"), 14, 34, -12829636, false);
    }
}
