package com.matrix.pigmanoptimiser.manager;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import org.bukkit.entity.LivingEntity;

public class ControlManager 
{
	private LivingEntity target;
	public ControlManager(LivingEntity target)
	{
		this.target=target;
	}
	public void doJump()
	{
		PigmanOptimiser.nms_control.doJump(this.target);
	}
	public void setJump()
	{
		PigmanOptimiser.nms_control.setJump(this.target);
	}
	public void setMoveTo(double x,double y,double z,double speed)
	{
		PigmanOptimiser.nms_control.setMoveTo(this.target,x,y,z, speed);
	}
	public void lookTicks(double x,double y,double z)
	{
		PigmanOptimiser.nms_control.lookTicks(this.target,x,y,z);
	}
}
