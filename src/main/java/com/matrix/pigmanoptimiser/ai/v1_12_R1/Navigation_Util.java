package com.matrix.pigmanoptimiser.ai.v1_12_R1;

import org.bukkit.entity.LivingEntity;

import com.matrix.pigmanoptimiser.ai.Navigation_Util_Main;


public class Navigation_Util implements Navigation_Util_Main
{

	@Override
	public boolean navigationTo(LivingEntity target, double x, double y, double z, double speed) 
	{
		return new AI_Util().getHandle(target).getNavigation().a(x, y, z, speed);
	}

	@Override
	public boolean navigationTo(LivingEntity target, LivingEntity le, double speed) 
	{
		return new AI_Util().getHandle(target).getNavigation().a(new AI_Util().getHandle(le), speed);
	}

	@Override
	public void stop(LivingEntity target) 
	{
		new AI_Util().getHandle(target).getNavigation().p();
	}

	@Override
	public void ticks(LivingEntity target)
	{
		new AI_Util().getHandle(target).getNavigation().d();
	}

	@Override
	public boolean noPath(LivingEntity target) 
	{
		return new AI_Util().getHandle(target).getNavigation().o();
	}
	@Override
	public boolean tryNavigationTo(LivingEntity target, double x, double y, double z, double speed) 
	{
		
		this.navigationTo(target, x, y, z, speed);
		return this.noPath(target);
	}
}
