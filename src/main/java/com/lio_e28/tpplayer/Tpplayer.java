package com.lio_e28.tpplayer;

import com.lio_e28.tpplayer.command.GiveTpPlayer;
import com.lio_e28.tpplayer.event.TpClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tpplayer extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginCommand("givetpplayer").setExecutor(new GiveTpPlayer());
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TpClickEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
