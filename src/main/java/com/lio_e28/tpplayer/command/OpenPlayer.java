package com.lio_e28.tpplayer.command;


import com.lio_e28.tpplayer.gui.TpGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            TpGUI inv = new TpGUI();
            inv.openTeleportGUI(player);
        }
        return false;
    }
}
