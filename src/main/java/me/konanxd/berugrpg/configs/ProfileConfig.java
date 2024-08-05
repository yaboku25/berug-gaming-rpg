package me.konanxd.berugrpg.configs;

import me.konanxd.berugrpg.BerugRPG;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.konanxd.berugrpg.utils.StringUtility.log;

public abstract class ProfileConfig extends YamlConfiguration {

    private final BerugRPG main;
    private static String playerName;
    private static File playerFile;

    public ProfileConfig(BerugRPG main, String playerName) {
        this.main = main;
        this.playerName = playerName;
        playerFile = new File(main.getDataFolder() + "/PlayerData", playerName + ".yml");
    }

    private void checkFile() {
        if (!playerFile.exists()) {
            try {
                playerFile.getParentFile().mkdirs();
                playerFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    // load the content of the files into memory
    public void loadPlayerConfig() {
        checkFile();
        try {
            load(playerFile);
            log("Loaded data from " + playerName + "!");
        } catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
            log("Error loading data from " + playerName + "!");
        }
    }

    // save the content of the files
    public void savePlayerConfig() {
        checkFile();
        try {
            save(playerFile);
            log("Saved data from " + playerName + "!");
        } catch (IOException exception) {
            exception.printStackTrace();
            log("Error saving data from " + playerName + "!");
        }
    }

    public boolean isConfigEmpty() {
        return getKeys(false).isEmpty();
    }

    public abstract void addDefaultSetting();

}
