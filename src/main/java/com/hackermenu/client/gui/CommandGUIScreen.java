package net.bennysmith.hackermenu.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.bennysmith.hackermenu.network.CommandGUIButtonMessage;
import net.bennysmith.hackermenu.world.inventory.CommandGUIMenu;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.gui.widget.WidgetSprites;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CommandGUIScreen extends HandledScreen<CommandGUIMenu> {
    private static final HashMap<String, Object> guistate = CommandGUIMenu.guistate;
    private final net.minecraft.world.World world;
    private final int x;
    private final int y;
    private final int z;
    private final net.minecraft.entity.player.PlayerEntity entity;
    TextFieldWidget servercommands;
    ButtonWidget button_execute_com;
    TexturedButtonWidget imagebutton_potion_page;
    private static final Identifier texture = Identifier.of("hackermenu", "textures/screens/command_gui.png");

    public CommandGUIScreen(CommandGUIMenu container, PlayerInventory inventory, Text text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = inventory.player;
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(context, mouseX, mouseY, partialTicks);
        super.render(context, mouseX, mouseY, partialTicks);
        this.servercommands.render(context, mouseX, mouseY, partialTicks);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        context.drawTexture(texture, this.x, this.y, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, this.backgroundWidth, this.backgroundHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.client.player.closeHandledScreen();
            return true;
        } else {
            return this.servercommands.isFocused() ? this.servercommands.keyPressed(key, b, c) : super.keyPressed(key, b, c);
        }
    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        String servercommandsValue = this.servercommands.getText();
        super.resize(client, width, height);
        this.servercommands.setText(servercommandsValue);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.command_gui.label_command_page"), 101, 4, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.command_gui.label_back"), 26, 6, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        this.servercommands = new TextFieldWidget(
            this.textRenderer, this.x + 4, this.y + 28, 167, 18, Text.translatable("gui.hackermenu.command_gui.servercommands")
        ) {
            @Override
            public void write(String text) {
                super.write(text);
                if (this.getText().isEmpty()) {
                    this.setSuggestion(Text.translatable("gui.hackermenu.command_gui.servercommands").getString());
                } else {
                    this.setSuggestion(null);
                }
            }

            @Override
            public void setCursor(int pos, boolean flag) {
                super.setCursor(pos, flag);
                if (this.getText().isEmpty()) {
                    this.setSuggestion(Text.translatable("gui.hackermenu.command_gui.servercommands").getString());
                } else {
                    this.setSuggestion(null);
                }
            }
        };
        this.servercommands.setMaxLength(32767);
        this.servercommands.setSuggestion(Text.translatable("gui.hackermenu.command_gui.servercommands").getString());
        guistate.put("text:servercommands", this.servercommands);
        this.addDrawableChild(this.servercommands);
        
        this.button_execute_com = ButtonWidget.builder(Text.translatable("gui.hackermenu.command_gui.button_execute_com"), e -> {
            ClientPlayNetworking.send(new CommandGUIButtonMessage(0, this.x, this.y, this.z, this.servercommands.getText()));
        }).dimensions(this.x + 41, this.y + 46, 93, 20).build();
        guistate.put("button:button_execute_com", this.button_execute_com);
        this.addDrawableChild(this.button_execute_com);
        
        this.imagebutton_potion_page = new TexturedButtonWidget(
            this.x + 3,
            this.y + 2,
            16,
            16,
            new WidgetSprites(
                Identifier.of("hackermenu", "textures/screens/potion_page.png"),
                Identifier.of("hackermenu", "textures/screens/potion_page.png")
            ),
            e -> ClientPlayNetworking.send(new CommandGUIButtonMessage(1, this.x, this.y, this.z, ""))
        );
        guistate.put("button:imagebutton_potion_page", this.imagebutton_potion_page);
        this.addDrawableChild(this.imagebutton_potion_page);
    }
}
