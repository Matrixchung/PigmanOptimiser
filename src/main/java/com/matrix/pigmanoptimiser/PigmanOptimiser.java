package com.matrix.pigmanoptimiser;

import com.matrix.pigmanoptimiser.ai.*;
import com.matrix.pigmanoptimiser.command.OnPlayerCommand;
import com.matrix.pigmanoptimiser.events.OnEntitySpawn;
import com.matrix.pigmanoptimiser.manager.ChunkManager;
import com.matrix.pigmanoptimiser.reflect.ReflectionManager;
import com.matrix.pigmanoptimiser.tasks.MainTimerTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public final class PigmanOptimiser extends JavaPlugin {
    private static PigmanOptimiser plugin;

    public static HashSet<String> disableWorlds ;
    public static int perChunkLimit ;
    public static int perWorldLimit ;

    static public AI_Util_Main nms_ai;
    static public Navigation_Util_Main nms_nav;
    static public Control_Util_Main nms_control;
    static public Attribute_Util_Main nms_attr;
    @Override
    public void onLoad() {
        plugin=this;
        List<String> loadChunkLists ;
        try{
            saveDefaultConfig();
            disableWorlds = new HashSet<>(getConfig().getStringList("disableWorlds"));
            loadChunkLists = getConfig().getStringList("pigManChunkLists");
            perChunkLimit = getConfig().getInt("perChunkLimit");
            perWorldLimit = getConfig().getInt("perWorldPigManLimit");

            for(String s:loadChunkLists){
                String[] t=s.split(" ");
                ChunkManager.add(Integer.parseInt(t[1]),Integer.parseInt(t[2]),t[0]);
            }
        }catch (Exception e){
            getLogger().warning("加载配置时出现问题: "+e.toString());
        }

    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Minecraft 版本: "+ReflectionManager.getVersion());
        switch (ReflectionManager.getVersion()){
            case "v1_12_R1":
                nms_ai=new com.matrix.pigmanoptimiser.ai.v1_12_R1.AI_Util();
                nms_nav=new com.matrix.pigmanoptimiser.ai.v1_12_R1.Navigation_Util();
                nms_control=new com.matrix.pigmanoptimiser.ai.v1_12_R1.Control_Util();
                nms_attr=new com.matrix.pigmanoptimiser.ai.v1_12_R1.Attribute_Util();
                break;
            case "v1_13_R2":
                nms_ai=new com.matrix.pigmanoptimiser.ai.v1_13_R2.AI_Util();
                nms_nav=new com.matrix.pigmanoptimiser.ai.v1_13_R2.Navigation_Util();
                nms_control=new com.matrix.pigmanoptimiser.ai.v1_13_R2.Control_Util();
                nms_attr=new com.matrix.pigmanoptimiser.ai.v1_13_R2.Attribute_Util();
                break;
            case "v1_14_R1":
                nms_ai=new com.matrix.pigmanoptimiser.ai.v1_14_R1.AI_Util();
                nms_nav=new com.matrix.pigmanoptimiser.ai.v1_14_R1.Navigation_Util();
                nms_control=new com.matrix.pigmanoptimiser.ai.v1_14_R1.Control_Util();
                nms_attr=new com.matrix.pigmanoptimiser.ai.v1_14_R1.Attribute_Util();
                break;
            case "v1_15_R1":
                nms_ai=new com.matrix.pigmanoptimiser.ai.v1_15_R1.AI_Util();
                nms_nav=new com.matrix.pigmanoptimiser.ai.v1_15_R1.Navigation_Util();
                nms_control=new com.matrix.pigmanoptimiser.ai.v1_15_R1.Control_Util();
                nms_attr=new com.matrix.pigmanoptimiser.ai.v1_15_R1.Attribute_Util();
                break;
            default:
                nms_ai = null;
                nms_nav = null;
                nms_control = null;
                nms_attr = null;
                getLogger().warning("不支持您的 Minecraft 版本,插件将不会启动！");
                return;
        }
        Bukkit.getPluginCommand("pigman").setExecutor(new OnPlayerCommand());
        Bukkit.getPluginManager().registerEvents(new OnEntitySpawn(),this);

        for(String s:ChunkManager.printAll()){
            getLogger().info(s);
        }
        //MainTimerTask task = new MainTimerTask();
        //Bukkit.getScheduler().runTaskLaterAsynchronously(this, task ,20);
        getLogger().info("PigmanOptimiser 已启动");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getScheduler().cancelTasks(this);
        if(!ChunkManager.addList.isEmpty()){
            ArrayList<String> perList = (ArrayList<String>) getConfig().get("pigManChunkLists");
            perList.addAll(ChunkManager.addList);
            getConfig().set("pigManChunkLists",perList);
        }
    }
    public static PigmanOptimiser getPlugin(){
        return plugin;
    }
}
