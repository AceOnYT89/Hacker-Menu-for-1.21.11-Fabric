package com.hackermenu.init;

import com.hackermenu.client.gui.CommandGUIScreen;
import com.hackermenu.client.gui.PotionguiScreen;
import com.hackermenu.client.gui.ThemenuguiScreen;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class HackermenuModScreens {
    public static void register() {
        HandledScreens.register(HackermenuModMenus.THEMENUGUI, ThemenuguiScreen::new);
        HandledScreens.register(HackermenuModMenus.POTIONGUI, PotionguiScreen::new);
        HandledScreens.register(HackermenuModMenus.COMMAND_GUI, CommandGUIScreen::new);
    }
}
