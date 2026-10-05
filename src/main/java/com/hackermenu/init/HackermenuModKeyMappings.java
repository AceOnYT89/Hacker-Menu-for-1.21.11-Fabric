package com.hackermenu.init;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HackermenuModKeyMappings {
    public static final KeyBinding DEBUGGER = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.hackermenu.debugger", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F7, "category.hackermenu")
    );

    public static void register() {
    }
}
