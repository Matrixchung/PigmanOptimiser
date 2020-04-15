package com.matrix.pigmanoptimiser;

import com.matrix.pigmanoptimiser.manager.AIManager;
import org.bukkit.entity.LivingEntity;

public class PigZombieAI {
    public static void applyCustomAI(LivingEntity e) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException{
        AIManager manager = new AIManager(e);
        manager.killAttackAI();
        manager.killAI();
        manager.addPigmanAI(0);
    }
}
