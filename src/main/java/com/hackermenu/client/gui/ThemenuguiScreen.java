package com.hackermenu.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ThemenuguiScreen extends GuiScreenBase {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/themenugui.png");

    public ThemenuguiScreen(net.minecraft.client.gui.screen.Screen parent) { super(Text.translatable("screen.hackermenu.theme")); }

    @Override protected void init() {
        int left = (width - 300) / 2, top = (height - 173) / 2;
        add(left+5, top+86, 61,20, () -> {});
        add(left+5, top+106,61,20, () -> {});
        add(left+5, top+126,61,20, () -> {});
        add(left+233,top+84,61,20, () -> {});
        add(left+233,top+104,61,20, () -> {});
        add(left+233,top+124,61,20, () -> {});
        add(left+233,top+144,61,20, () -> {});
        add(left+134,top+64,30,20, () -> {});
        add(left+35,top+44,25,20, () -> {});
        add(left+10,top+44,25,20, () -> {});
        add(left+281,top+4,16,16, () -> {});
        add(left+4,top+4,16,16, () -> MinecraftClient.getInstance().setScreen(new PotionguiScreen(this)));
    }

    private void add(int x,int y,int w,int h,Runnable action) { addDrawableChild(new InvisibleButton(x,y,w,h,action)); }

    @Override public void render(DrawContext context,int mouseX,int mouseY,float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        drawCenteredTexture(context,TEXTURE,300,173);
        super.render(context,mouseX,mouseY,delta);
    }
}
