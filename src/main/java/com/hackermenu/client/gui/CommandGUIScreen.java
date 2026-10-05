package com.hackermenu.client.gui;

import com.hackermenu.world.inventory.CommandGUIMenu;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ImageButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CommandGUIScreen extends HandledScreen<CommandGUIMenu> {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/command_gui.png");
    private TextFieldWidget commandField;

    public CommandGUIScreen(CommandGUIMenu handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        int x = this.x;
        int y = this.y;

        commandField = new TextFieldWidget(this.textRenderer, x + 4, y + 28, 167, 18, Text.empty());
        commandField.setMaxLength(32767);
        commandField.setDrawsBackground(false);
        addDrawableChild(commandField);

        addDrawableChild(ButtonWidget.builder(Text.translatable("gui.hackermenu.command_gui.button_execute_com"), e -> {
            if (client != null && client.player != null) {
                com.hackermenu.network.CommandGUIButtonMessage.sendToServer(0, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ(), commandField.getText());
            }
        }).dimensions(x + 41, y + 46, 93, 20).build());

        addDrawableChild(new ImageButtonWidget(x + 3, y + 2, 16, 16, 0, 0, 0,
                Identifier.of("hackermenu", "textures/gui/potion_page.png"), 16, 16,
                btn -> {
                    if (client != null && client.player != null) {
                        com.hackermenu.network.CommandGUIButtonMessage.sendToServer(1, (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ(), "");
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
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.command_gui.label_command_page"), 101, 4, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.command_gui.label_back"), 26, 6, -12829636, false);
    }
}
