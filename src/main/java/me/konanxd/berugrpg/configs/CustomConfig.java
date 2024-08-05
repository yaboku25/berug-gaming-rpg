package me.konanxd.berugrpg.configs;

import me.konanxd.berugrpg.BerugRPG;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.konanxd.berugrpg.utils.StringUtility.log;

public abstract class CustomConfig extends YamlConfiguration {

    private final BerugRPG main;
    private final String name;
    private final File file;

    public CustomConfig(BerugRPG main, String name) {
        this.main = main;
        this.name = name;
        file = new File(main.getDataFolder(), name);
    }

    private void checkFile() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            main.saveResource(name, false);
        }
    }

    // load the content of the files into memory
    public void loadConfig() {
        checkFile();
        try {
            load(file);
            log("Loaded data from " + name + "!");
        } catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
            log("Error loading data from " + name + "!");
        }
    }

    // save the content of the files
    public void saveConfig() {
        checkFile();
        try {
            save(file);
            log("Saved data from " + name + "!");
        } catch (IOException exception) {
            exception.printStackTrace();
            log("Error saving data from " + name + "!");
        }
    }

}
