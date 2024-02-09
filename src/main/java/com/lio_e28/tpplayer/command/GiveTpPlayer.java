package com.lio_e28.tpplayer.command;


import com.lio_e28.tpplayer.item.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveTpPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            switch (args.length){
                case 0:
                    sender.sendMessage("TPplayer이 지급되었습니다.");
                    player.getInventory().addItem(ItemManager.tpplayer);
                    break;
                case 1:
                    try{
                        int amount = Integer.parseInt(args[0]);
                        ItemStack tpplayer = new ItemStack(ItemManager.tpplayer);
                        tpplayer.setAmount(amount);
                        player.getInventory().addItem(tpplayer);
                        break;
                    }catch (NumberFormatException e){
                        player.sendMessage("명령어를 재대로 입력해주세요.");
                        return false;
                    }catch (Exception e){
                        player.sendMessage("명령어를 재대로 입력해주세요.");
                        return false;
                    }
            }
        }else{
            sender.sendMessage("콘솔 불가능");
        }
        return false;
    }
}
