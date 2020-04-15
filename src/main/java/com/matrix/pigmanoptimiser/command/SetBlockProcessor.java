package com.matrix.pigmanoptimiser.command;

import com.matrix.pigmanoptimiser.manager.BlockManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetBlockProcessor {
    public static void setBlock(CommandSender sender,int X,int Y,int Z){
        if(!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED+"[PigmanOptimiser]未指定世界，默认设置 world !");
            BlockManager.add(X,Y,Z,"world");
            sender.sendMessage(ChatColor.AQUA+"[PigmanOptimiser]已添加位置: X: "+X+" Y: "+Y+" Z: "+Z+" World: world");
        }
        else{
            String worldName = ((Player) sender).getPlayer().getWorld().getName();
            BlockManager.add(X,Y,Z,worldName);
            sender.sendMessage(ChatColor.AQUA+"[PigmanOptimiser]已添加位置: X: "+X+" Y: "+Y+" Z: "+Z+" World: "+worldName);
        }
    }
}
