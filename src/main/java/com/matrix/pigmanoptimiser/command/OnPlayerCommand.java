package com.matrix.pigmanoptimiser.command;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OnPlayerCommand implements TabExecutor {
    private String[] subCommands = {"setBlock","setChunk","reload"};
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player &&(!commandSender.hasPermission("pigmanoptimiser.use"))){
            commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]您没有权限!");
            return true;
        }
        switch(args.length){
            case 1:
                switch (args[0]){
                    case "setChunk":
                        if(!(commandSender instanceof Player)) commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]此命令无法在控制台执行!");
                        else {SetChunkProcessor.setChunk(commandSender);}
                        return true;
                    case "setBlock":
                        commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setBlock> <X> <Y> <Z>");
                        return true;
                    case "reload":
                        PigmanOptimiser.getPlugin().reloadConfig();
                        commandSender.sendMessage(ChatColor.AQUA+"[PigmanOptimiser]插件已重载!");
                        return true;
                    default:
                        commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setChunk> / <reload> / <setBlock> <X> <Y> <Z>");
                        return true;
                }
            case 4:
                if(args[0].equalsIgnoreCase("setBlock")&&isNumeric(args[1])&&isNumeric(args[2])&&isNumeric(args[3])){
                    SetBlockProcessor.setBlock(commandSender,Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                }else{
                    commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setBlock> <X> <Y> <Z>");
                }
                return true;
            default:
                commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setChunk> / <reload> / <setBlock> <X> <Y> <Z>");
                return true;
        }
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length>1&&args[0].equalsIgnoreCase("setBlock")){

        }
        if(args.length == 0) return Arrays.asList(subCommands);
        return Arrays.stream(subCommands).filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
    }
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
