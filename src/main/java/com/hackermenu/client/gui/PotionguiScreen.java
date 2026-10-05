package com.hackermenu.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PotionguiScreen extends GuiScreenBase {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/potiongui.png");

    public PotionguiScreen(net.minecraft.client.gui.screen.Screen parent) { super(Text.translatable("screen.hackermenu.potion")); }

    @Override protected void init() {
        int left=(width-176)/2, top=(height-166)/2;
        add(left+6,top+34,77,20);
        add(left+92,top+34,77,20);
        add(left+92,top+61,77,20);
        add(left+92,top+88,77,20);
        add(left+6,top+61,77,20);
        add(left+6,top+88,77,20);
        add(left+51,top+124,77,20);
        add(left+150,top+7,16,16, () -> MinecraftClient.getInstance().setScreen(new ThemenuguiScreen(this)));
    }

    private void add(int x,int y,int w,int h) { add(x,y,w,h,()->{}); }
    private void add(int x,int y,int w,int h,Runnable action) { addDrawableChild(new InvisibleButton(x,y,w,h,action)); }

    @Override public void render(DrawContext context,int mouseX,int mouseY,float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        drawCenteredTexture(context,TEXTURE,176,166);
        super.render(context,mouseX,mouseY,delta);
    }
}
