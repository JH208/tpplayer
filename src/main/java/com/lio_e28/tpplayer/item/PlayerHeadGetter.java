package com.lio_e28.tpplayer.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHeadGetter {
    public static ItemStack getPlayerHead(String PlayerName){
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();

        // 플레이어의 이름을 설정하여 머리를 얻음
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(PlayerName));
        head.setItemMeta(skullMeta);

        return head;
    }

}
