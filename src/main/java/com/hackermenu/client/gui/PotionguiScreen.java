package net.bennysmith.hackermenu.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.bennysmith.hackermenu.network.PotionguiButtonMessage;
import net.bennysmith.hackermenu.world.inventory.PotionguiMenu;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.gui.widget.WidgetSprites;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PotionguiScreen extends HandledScreen<PotionguiMenu> {
    private static final HashMap<String, Object> guistate = PotionguiMenu.guistate;
    private final net.minecraft.world.World world;
    private final int x;
    private final int y;
    private final int z;
    private final net.minecraft.entity.player.PlayerEntity entity;
    ButtonWidget button_quick_mine;
    ButtonWidget button_quick_mine1;
    ButtonWidget button_quick_mine2;
    ButtonWidget button_quick_mine3;
    ButtonWidget button_quick_mine4;
    ButtonWidget button_quick_mine5;
    ButtonWidget button_quick_mine6;
    TexturedButtonWidget imagebutton_forward;
    private static final Identifier texture = Identifier.of("hackermenu", "textures/screens/potiongui.png");

    public PotionguiScreen(PotionguiMenu container, PlayerInventory inventory, Text text) {
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
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.potiongui.label_potion_page"), 60, 151, -12829636, false);
        context.drawText(this.textRenderer, Text.translatable("gui.hackermenu.potiongui.label_back"), 121, 11, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        this.button_quick_mine = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(0, this.x, this.y, this.z));
        }).dimensions(this.x + 6, this.y + 34, 77, 20).build();
        guistate.put("button:button_quick_mine", this.button_quick_mine);
        this.addDrawableChild(this.button_quick_mine);
        
        this.button_quick_mine1 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine1"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(1, this.x, this.y, this.z));
        }).dimensions(this.x + 92, this.y + 34, 77, 20).build();
        guistate.put("button:button_quick_mine1", this.button_quick_mine1);
        this.addDrawableChild(this.button_quick_mine1);
        
        this.button_quick_mine2 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine2"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(2, this.x, this.y, this.z));
        }).dimensions(this.x + 92, this.y + 61, 77, 20).build();
        guistate.put("button:button_quick_mine2", this.button_quick_mine2);
        this.addDrawableChild(this.button_quick_mine2);
        
        this.button_quick_mine3 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine3"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(3, this.x, this.y, this.z));
        }).dimensions(this.x + 92, this.y + 88, 77, 20).build();
        guistate.put("button:button_quick_mine3", this.button_quick_mine3);
        this.addDrawableChild(this.button_quick_mine3);
        
        this.button_quick_mine4 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine4"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(4, this.x, this.y, this.z));
        }).dimensions(this.x + 6, this.y + 61, 77, 20).build();
        guistate.put("button:button_quick_mine4", this.button_quick_mine4);
        this.addDrawableChild(this.button_quick_mine4);
        
        this.button_quick_mine5 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine5"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(5, this.x, this.y, this.z));
        }).dimensions(this.x + 6, this.y + 88, 77, 20).build();
        guistate.put("button:button_quick_mine5", this.button_quick_mine5);
        this.addDrawableChild(this.button_quick_mine5);
        
        this.button_quick_mine6 = ButtonWidget.builder(Text.translatable("gui.hackermenu.potiongui.button_quick_mine6"), e -> {
            ClientPlayNetworking.send(new PotionguiButtonMessage(6, this.x, this.y, this.z));
        }).dimensions(this.x + 51, this.y + 124, 77, 20).build();
        guistate.put("button:button_quick_mine6", this.button_quick_mine6);
        this.addDrawableChild(this.button_quick_mine6);
        
        this.imagebutton_forward = new TexturedButtonWidget(
            this.x + 150,
            this.y + 7,
            16,
            16,
            new WidgetSprites(
                Identifier.of("hackermenu", "textures/screens/forward.png"),
                Identifier.of("hackermenu", "textures/screens/forward.png")
            ),
            e -> ClientPlayNetworking.send(new PotionguiButtonMessage(7, this.x, this.y, this.z))
        );
        guistate.put("button:imagebutton_forward", this.imagebutton_forward);
        this.addDrawableChild(this.imagebutton_forward);
    }
}
