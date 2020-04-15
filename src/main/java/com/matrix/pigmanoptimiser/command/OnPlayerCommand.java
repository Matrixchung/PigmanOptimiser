package com.matrix.pigmanoptimiser.command;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import com.matrix.pigmanoptimiser.debug.DebugPigmanGenerator;
import com.matrix.pigmanoptimiser.manager.ChunkManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import sun.security.ssl.Debug;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OnPlayerCommand implements TabExecutor {
    private String[] subCommands = {"setBlock","setChunk","reload","check"};
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!s.equalsIgnoreCase("pigman")) return true;
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
                    case "check":
                        if(commandSender instanceof Player) {
                            if(ChunkManager.check(((Player) commandSender).getChunk())){
                                commandSender.sendMessage(ChatColor.AQUA+"[PigmanOptimiser]当前区块为猪人区块!");
                            }else commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]当前区块不是猪人区块!");
                        }
                        else{
                            commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]此命令无法在控制台执行!");
                        }
                        return true;
                    case "debug":
                        if(commandSender instanceof Player){
                            try {
                                DebugPigmanGenerator.generateDebugMobs((Player) commandSender);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    default:
                        commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setChunk> / <reload> / <check> / <setBlock> <X> <Y> <Z>");
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
                commandSender.sendMessage(ChatColor.RED+"[PigmanOptimiser]"+ChatColor.AQUA+"用法: /pigman <setChunk> / <reload> / <check> / <setBlock> <X> <Y> <Z>");
                return true;
        }
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length>1) return null;
        if(args.length == 0) return Arrays.asList(subCommands);
        return Arrays.stream(subCommands).filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
    }
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
;