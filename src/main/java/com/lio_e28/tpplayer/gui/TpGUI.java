package com.lio_e28.tpplayer.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.lio_e28.tpplayer.item.PlayerHeadGetter.getPlayerHead;

public class TpGUI implements Listener {

    public static void openTeleportGUI(org.bukkit.entity.Player player) {
        // GUI 생성
        Inventory gui = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "텔레포트 대상 선택");

        // GUI에 플레이어 목록 추가
        for (org.bukkit.entity.Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            ItemStack playerHead = getPlayerHead(onlinePlayer.getName());
            gui.addItem(playerHead);
        }

        // GUI 열기
        player.openInventory(gui);
    }
}


