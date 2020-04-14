package com.matrix.pigmanoptimiser.entity;

import org.bukkit.entity.LivingEntity;


public abstract class MyEntityAbstract 
{
	abstract public LivingEntity getBukkitEntity();
	abstract public void spawnEntity() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	abstract boolean isSpawned();
}
