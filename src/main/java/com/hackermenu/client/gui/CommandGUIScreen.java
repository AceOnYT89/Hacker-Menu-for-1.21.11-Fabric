package com.hackermenu.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CommandGUIScreen extends GuiScreenBase {
    private static final Identifier TEXTURE = Identifier.of("hackermenu", "textures/gui/command_gui.png");
    private TextFieldWidget commandField;

    public CommandGUIScreen(net.minecraft.client.gui.screen.Screen parent) { super(Text.translatable("screen.hackermenu.command")); }

    @Override protected void init() {
        int left=(width-176)/2, top=(height-166)/2;
        commandField = new TextFieldWidget(textRenderer,left+4,top+28,167,18,Text.empty());
        commandField.setMaxLength(32767);
        commandField.setDrawsBackground(false);
        addDrawableChild(commandField);
        // Visual-only execute button: no command/network action.
        addDrawableChild(new InvisibleButton(left+41,top+46,93,20,()->{}));
        addDrawableChild(new InvisibleButton(left+3,top+2,16,16,
                () -> MinecraftClient.getInstance().setScreen(new PotionguiScreen(this))));
    }

    @Override public void render(DrawContext context,int mouseX,int mouseY,float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        drawCenteredTexture(context,TEXTURE,176,166);
        super.render(context,mouseX,mouseY,delta);
    }
}
