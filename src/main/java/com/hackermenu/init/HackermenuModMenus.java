package com.hackermenu.init;

import com.hackermenu.world.inventory.CommandGUIMenu;
import com.hackermenu.world.inventory.PotionguiMenu;
import com.hackermenu.world.inventory.ThemenuguiMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class HackermenuModMenus {
    public static final ScreenHandlerType<ThemenuguiMenu> THEMENUGUI = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of("hackermenu", "themenugui"),
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new ThemenuguiMenu(syncId, inventory))
    );

    public static final ScreenHandlerType<PotionguiMenu> POTIONGUI = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of("hackermenu", "potiongui"),
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new PotionguiMenu(syncId, inventory))
    );

    public static final ScreenHandlerType<CommandGUIMenu> COMMAND_GUI = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of("hackermenu", "command_gui"),
            new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new CommandGUIMenu(syncId, inventory))
    );

    public static void register() {
    }
}
