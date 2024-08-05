package me.konanxd.berugrpg.managers;

import me.konanxd.berugrpg.BerugRPG;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {

    public enum Stats {
        STRENGTH,
        AGILITY,
        INTELLIGENCE
    }

    private static StatsManager instance;

    public static StatsManager getInstance(BerugRPG main) {
        if (instance == null) {
            instance = new StatsManager(main);
        }
        return instance;
    }

    private final BerugRPG main;
    private final Map<String, Integer> playerStats;

    public StatsManager(BerugRPG main) {
        this.main = main;
        playerStats = new HashMap<>();
    }

    private void initiateStats() {
        playerStats.put("str", 0);
        playerStats.put("agi", 0);
        playerStats.put("int", 0);
    }

    public void addStats(String stat, int value) {
        int statValue = playerStats.get(stat);
        statValue += value;

        playerStats.put(stat, statValue);
    }



}
