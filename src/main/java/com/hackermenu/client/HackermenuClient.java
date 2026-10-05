package com.hackermenu.client;

import com.hackermenu.client.gui.ThemenuguiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HackermenuClient implements ClientModInitializer {
    private KeyBinding openKey;

    @Override
    public void onInitializeClient() {
        openKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hackermenu.open", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, "category.hackermenu"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openKey.wasPressed()) {
                if (client.currentScreen == null) client.setScreen(new ThemenuguiScreen(null));
            }
        });
    }
}
