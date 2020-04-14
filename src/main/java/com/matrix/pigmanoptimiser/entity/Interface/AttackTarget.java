package com.matrix.pigmanoptimiser.entity.Interface;

import org.bukkit.entity.LivingEntity;

public interface AttackTarget 
{
	public LivingEntity getTarget();
	public boolean hasTarget();
	public void setTarget(LivingEntity s);  
	void openKeepAttackTargetFunction(int prop);
}
