package com.lio_e28.tpplayer.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Objects;

import static com.lio_e28.tpplayer.gui.TpGUI.openTeleportGUI;
import static com.lio_e28.tpplayer.item.ItemManager.tpplayer;


public class TpClickEvent implements Listener {
    @EventHandler
    public void tpRightClickEvent(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().isSimilar(tpplayer)) {
            event.setCancelled(true);

            Player player = event.getPlayer();

            if(player.isOp() || player.hasPermission("tp.click")){
                openTeleportGUI(player);
            }else{
                player.sendMessage("권한이 없습니다.");
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        String title = ChatColor.stripColor(e.getView().getTitle());

        if (title.equals("텔레포트 대상 선택")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem.getType() == Material.PLAYER_HEAD && clickedItem.hasItemMeta()) {
                SkullMeta skullMeta = (SkullMeta) clickedItem.getItemMeta();
                String playerName = skullMeta.getOwner();

                if (playerName != null) {
                    Player targetPlayer = Objects.requireNonNull(Bukkit.getPlayer(playerName));

                    if (targetPlayer != null) {
                        Player player = (Player) e.getWhoClicked();
                        player.teleport(targetPlayer.getLocation());
                        player.sendMessage("플레이어에게 순간이동하였습니다.");
                    }

                }
            }
        }
    }
}