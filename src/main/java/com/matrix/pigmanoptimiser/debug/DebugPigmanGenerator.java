package com.matrix.pigmanoptimiser.debug;

import com.matrix.pigmanoptimiser.PigZombieAI;
import com.matrix.pigmanoptimiser.entity.MyEntity;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class DebugPigmanGenerator {
    public static void generateDebugMobs(Player player) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Location loc = player.getLocation();
        MyEntity zombiePigman = new MyEntity(EntityType.PIG_ZOMBIE,loc);
        for(int i=0;i<=500;i++){
            zombiePigman.spawnEntity();
            PigZombieAI.applyCustomAI(zombiePigman.getBukkitEntity());
        }
    }
}
