package com.lio_e28.tpplayer.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {
    public static final ItemStack tpplayer = buildItem(Material.NETHER_STAR, 1, ChatColor.LIGHT_PURPLE + "텔레포트", ChatColor.WHITE+"대상에게 순간이동!");

    private static ItemStack buildItem(Material type, int amount, String displayName, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        if (meta != null){
            meta.setDisplayName(displayName);
            meta.setLore(Arrays.asList(lore));
            stack.setItemMeta(meta);
        } else {
            System.err.println("ItemMeta is null for item: " + type.toString());
        }
        return stack;
    }
}
