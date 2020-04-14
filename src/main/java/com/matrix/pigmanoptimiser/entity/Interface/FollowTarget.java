package com.matrix.pigmanoptimiser.entity.Interface;

import org.bukkit.entity.LivingEntity;

public interface FollowTarget 
{
	public LivingEntity getFollowTarget();
	public boolean hasFollowTarget();
	public void setFollowTarget(LivingEntity s);  
	void openKeepFollowTargetFunction(int prop);
}
