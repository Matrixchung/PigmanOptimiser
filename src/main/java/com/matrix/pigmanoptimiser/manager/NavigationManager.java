package com.matrix.pigmanoptimiser.manager;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import org.bukkit.entity.LivingEntity;

public class NavigationManager 
{
	private LivingEntity target;
	public NavigationManager(LivingEntity le)
	{
		this.target=le;
	}
	public boolean navigationTo(double x,double y,double z,double speed)
	{
		return PigmanOptimiser.nms_nav.navigationTo(this.target, x, y, z, speed);
	}
	public boolean navigationTo(LivingEntity le,double speed)
	{
		return PigmanOptimiser.nms_nav.navigationTo(target, le, speed);
	}
	public void stop()
	{
		PigmanOptimiser.nms_nav.stop(this.target);
	}
	public void ticks()
	{
		PigmanOptimiser.nms_nav.ticks(this.target);
	}
	public boolean noPath()
	{
		return PigmanOptimiser.nms_nav.noPath(this.target);
	}
}
