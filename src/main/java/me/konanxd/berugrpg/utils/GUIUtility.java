package me.konanxd.berugrpg.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.konanxd.berugrpg.utils.StringUtility.color;

public class GUIUtility {

    private final Inventory inventory;
    private final Player player;

    public GUIUtility(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }

    public void addMaterial(Material material, String name, int amount, int index) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ITEM_SPECIFICS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ARMOR_TRIM, ItemFlag.HIDE_DESTROYS);
        itemMeta.setDisplayName(color(name));
        item.setItemMeta(itemMeta);

        inventory.setItem(index, item);
    }

    public void addLore(int index, String... lore) {
        ItemStack item = inventory.getItem(index);
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(lore));
        item.setLore(list);
    }

    public void editLore(int index, int indexLore, String lore) {
        ItemStack item = inventory.getItem(index);
        ItemMeta meta = item.getItemMeta();
        List<String> list = meta.getLore();
        list.set(indexLore, color(lore));
        item.setLore(list);
    }

    public void addFiller(Material material, int startIndex, int endindex) {
        for (int i = startIndex; i < endindex + 1; i++) {
            addMaterial(material, " ", 1, i);
        }
    }

    public void addHead(Player player, String name, int index) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setOwner(player.getName());
        skull.setDisplayName(name);
        item.setItemMeta(skull);

        inventory.setItem(index, item);
    }

}
