package com.hackermenu.procedures;

import net.minecraft.command.CommandSource;
import net.minecraft.command.CommandSourceStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

public class BypasscommandsProcedure {
    public static void execute(WorldAccess world, double x, double y, double z, String commandText) {
        if (world instanceof ServerWorld serverWorld && commandText != null && !commandText.trim().isEmpty()) {
            serverWorld.getServer().getCommandManager().executeWithPrefix(
                    new CommandSourceStack(CommandSource.NULL, new Vec3d(x, y, z), Vec2f.ZERO, serverWorld, 4, "", Text.literal(""), serverWorld.getServer(), null).withSilentOutput(),
                    commandText
            );
        }
    }
}
