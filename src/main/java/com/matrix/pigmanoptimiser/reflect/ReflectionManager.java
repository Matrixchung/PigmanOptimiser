package com.matrix.pigmanoptimiser.reflect;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import org.bukkit.Bukkit;
import net.minecraft.server.v1_15_R1.EntityPigZombie;

public class ReflectionManager {
    static String packet = Bukkit.getServer().getClass().getPackage().getName();
    static String nmsVersion = packet.substring(packet.lastIndexOf('.') + 1);
    static String nmsName = "net.minecraft.server." + nmsVersion;
    public static String getVersion(){
        return nmsVersion;
    }
    public static Class<?> getPigManClass(){
        Class<?> nmsPigManClass = null;
        try{
            nmsPigManClass = Class.forName(nmsName+".EntityPigZombie");
        }
        catch(ClassNotFoundException e){
            PigmanOptimiser.getPlugin().getLogger().warning("Can't Found EntityPigZombie Class: "+e.getMessage());
        }
        return nmsPigManClass;
    }
}
