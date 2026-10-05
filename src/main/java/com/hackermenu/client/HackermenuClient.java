package net.bennysmith.hackermenu;

import net.bennysmith.hackermenu.init.HackermenuModMenus;
import net.bennysmith.hackermenu.network.CommandGUIButtonMessage;
import net.bennysmith.hackermenu.network.DebuggerMessage;
import net.bennysmith.hackermenu.network.PotionguiButtonMessage;
import net.bennysmith.hackermenu.network.ThemenuguiButtonMessage;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HackermenuMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hackermenu");
    public static final String MODID = "hackermenu";

    public record QueuedWork(Runnable action, int ticks) {
        public int decrement() { return ticks - 1; }
    }

    private static final ConcurrentLinkedQueue<QueuedWork> workQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void onInitialize() {
        HackermenuModMenus.register();

        // Register all network payloads
        CommandGUIButtonMessage.register();
        ThemenuguiButtonMessage.register();
        PotionguiButtonMessage.register();
        DebuggerMessage.register();

        ServerTickEvents.END_SERVER_TICK.register(server -> tick());
    }

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new QueuedWork(action, tick));
    }

    private static void tick() {
        List<QueuedWork> toRun = new ArrayList<>();
        workQueue.forEach(work -> {
            int remaining = work.decrement();
            if (remaining == 0) toRun.add(work);
        });
        toRun.forEach(w -> w.action().run());
        workQueue.removeAll(toRun);
    }
}
