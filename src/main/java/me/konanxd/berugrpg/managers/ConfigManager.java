package me.konanxd.berugrpg.managers;

import me.konanxd.berugrpg.BerugRPG;
import me.konanxd.berugrpg.configs.CustomConfig;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private final BerugRPG main;
    private List<CustomConfig> configs = new ArrayList<>();

    public ConfigManager(BerugRPG main) {
        this.main = main;
    }

    // load all config files at once
    public void loadConfigs() {
        for (CustomConfig config : configs) {
            config.loadConfig();
        }
    }

    // save all config files at once
    public void saveConfigs() {
        for (CustomConfig config : configs) {
            config.saveConfig();
        }
    }

}
