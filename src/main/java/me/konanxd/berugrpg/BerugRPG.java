package me.konanxd.berugrpg;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public final class BerugRPG extends JavaPlugin {

    private static Logger logger;

    @Override
    public void onEnable() {

        logger = getLogger();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Logger getPluginLogger() {
        return logger;
    }
}
