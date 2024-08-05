package me.konanxd.berugrpg.utils;

import me.konanxd.berugrpg.BerugRPG;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class StringUtility {

    // pull in the logger from the main class
    private static Logger logger = BerugRPG.getPluginLogger();

    // translates color code
    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    // strip color codes from string so they won't be any color code returned in quotes
    public static String decolor(String string) {
        return ChatColor.stripColor(color(string));
    }

    // log message
    public static void log(String... strings) {
        for (String string : strings) {
            logger.info(string);
        }
    }

    // player message
    public static void msgPlayer(Player player, String... strings) {
        for (String string : strings) {
            player.sendMessage(color(string));
        }
    }

    // action bar message
    public static void msgPlayerAB(Player player, String... strings) {
        for (String string : strings) {
            player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(color(string)));
        }
    }

}
