package com.hackermenu.client;

import com.hackermenu.client.gui.ThemenuguiScreen;
import com.hackermenu.init.HackermenuModKeyMappings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class HackermenuClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HackermenuModKeyMappings.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (HackermenuModKeyMappings.DEBUGGER.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new ThemenuguiScreen());
                }
            }
        });
    }
}
