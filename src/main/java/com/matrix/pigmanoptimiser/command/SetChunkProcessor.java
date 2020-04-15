package com.matrix.pigmanoptimiser.command;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import com.matrix.pigmanoptimiser.manager.ChunkManager;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetChunkProcessor {
    public static void setChunk(CommandSender sender){
        Player player = (Player) sender;
        Chunk chunk = player.getChunk();
        try{
            ChunkManager.add(chunk);
        }catch (Exception e){
            PigmanOptimiser.getPlugin().getLogger().warning("添加猪人区块时出现问题: "+e.toString());
        }
        sender.sendMessage(ChatColor.AQUA+"[PigmanOptimiser]已添加猪人区块: X: "+chunk.getX()+" Z: "+chunk.getZ()+" World: "+player.getWorld().getName());
    }
}
