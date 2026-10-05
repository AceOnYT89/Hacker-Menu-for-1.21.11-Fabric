package net.bennysmith.hackermenu.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.bennysmith.hackermenu.network.ThemenuguiButtonMessage;
import net.bennysmith.hackermenu.world.inventory.ThemenuguiMenu;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.gui.widget.WidgetSprites;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ThemenuguiScreen extends HandledScreen<ThemenuguiMenu> {
    private static final HashMap<String, Object> guistate = ThemenuguiMenu.guistate;
    private final net.minecraft.world.World world;
    private final int x;
    private final int y;
    private final int z;
    private final net.minecraft.entity.player.PlayerEntity entity;
    ButtonWidget button_surviva;
    ButtonWidget button_surviva1;
    ButtonWidget button_surviva2;
    ButtonWidget button_surviva3;
    ButtonWidget button_surviva4;
    ButtonWidget button_surviva5;
    ButtonWidget button_surviva6;
    ButtonWidget button_empty;
    ButtonWidget button_empty2;
    ButtonWidget button_empty1;
    TexturedButtonWidget imagebutton_forward;
    TexturedButtonWidget imagebutton_potion_page;
    private static final Identifier texture = Identifier.of("hackermenu", "textures/screens/themenugui.png");

    public ThemenuguiScreen(ThemenuguiMenu container, PlayerInventory inventory, Text text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = inventory.player;
        this.backgroundWidth = 300;
        this.backgroundHeight = 173;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(context, mouseX, mouseY, partialTicks);
        super.render(context, mouseX, mouseY, partialTicks);
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
            return super.keyPressed(key, b, c);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_next_page"), 207, 7, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_hacker_menu_v4"), 5, 162, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_potion_page"), 32, 7, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.themenugui.label_semigod"), 14, 34, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        this.button_surviva = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(0, this.x, this.y, this.z));
        }).dimensions(this.x + 5, this.y + 86, 61, 20).build();
        guistate.put("button:button_surviva", this.button_surviva);
        this.addDrawableChild(this.button_surviva);
        
        this.button_surviva1 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva1"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(1, this.x, this.y, this.z));
        }).dimensions(this.x + 5, this.y + 106, 61, 20).build();
        guistate.put("button:button_surviva1", this.button_surviva1);
        this.addDrawableChild(this.button_surviva1);
        
        this.button_surviva2 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva2"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(2, this.x, this.y, this.z));
        }).dimensions(this.x + 5, this.y + 126, 61, 20).build();
        guistate.put("button:button_surviva2", this.button_surviva2);
        this.addDrawableChild(this.button_surviva2);
        
        this.button_surviva3 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva3"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(3, this.x, this.y, this.z));
        }).dimensions(this.x + 233, this.y + 84, 61, 20).build();
        guistate.put("button:button_surviva3", this.button_surviva3);
        this.addDrawableChild(this.button_surviva3);
        
        this.button_surviva4 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva4"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(4, this.x, this.y, this.z));
        }).dimensions(this.x + 233, this.y + 104, 61, 20).build();
        guistate.put("button:button_surviva4", this.button_surviva4);
        this.addDrawableChild(this.button_surviva4);
        
        this.button_surviva5 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva5"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(5, this.x, this.y, this.z));
        }).dimensions(this.x + 233, this.y + 124, 61, 20).build();
        guistate.put("button:button_surviva5", this.button_surviva5);
        this.addDrawableChild(this.button_surviva5);
        
        this.button_surviva6 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_surviva6"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(6, this.x, this.y, this.z));
        }).dimensions(this.x + 233, this.y + 144, 61, 20).build();
        guistate.put("button:button_surviva6", this.button_surviva6);
        this.addDrawableChild(this.button_surviva6);
        
        this.button_empty = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(7, this.x, this.y, this.z));
        }).dimensions(this.x + 134, this.y + 64, 30, 20).build();
        guistate.put("button:button_empty", this.button_empty);
        this.addDrawableChild(this.button_empty);
        
        this.button_empty2 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty2"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(8, this.x, this.y, this.z));
        }).dimensions(this.x + 35, this.y + 44, 25, 20).build();
        guistate.put("button:button_empty2", this.button_empty2);
        this.addDrawableChild(this.button_empty2);
        
        this.button_empty1 = ButtonWidget.builder(Text.translatable("gui.hackermenu.themenugui.button_empty1"), e -> {
            ClientPlayNetworking.send(new ThemenuguiButtonMessage(9, this.x, this.y, this.z));
        }).dimensions(this.x + 10, this.y + 44, 25, 20).build();
        guistate.put("button:button_empty1", this.button_empty1);
        this.addDrawableChild(this.button_empty1);
        
        this.imagebutton_forward = new TexturedButtonWidget(
            this.x + 281,
            this.y + 4,
            16,
            16,
            new WidgetSprites(
                Identifier.of("hackermenu", "textures/screens/forward.png"),
                Identifier.of("hackermenu", "textures/screens/forward.png")
            ),
            e -> ClientPlayNetworking.send(new ThemenuguiButtonMessage(10, this.x, this.y, this.z))
        );
        guistate.put("button:imagebutton_forward", this.imagebutton_forward);
        this.addDrawableChild(this.imagebutton_forward);
        
        this.imagebutton_potion_page = new TexturedButtonWidget(
            this.x + 4,
            this.y + 4,
            16,
            16,
            new WidgetSprites(
                Identifier.of("hackermenu", "textures/screens/potion_page.png"),
                Identifier.of("hackermenu", "textures/screens/potion_page.png")
            ),
            e -> ClientPlayNetworking.send(new ThemenuguiButtonMessage(11, this.x, this.y, this.z))
        );
        guistate.put("button:imagebutton_potion_page", this.imagebutton_potion_page);
        this.addDrawableChild(this.imagebutton_potion_page);
    }
}
