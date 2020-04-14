package com.matrix.pigmanoptimiser.ai.v1_12_R1;

import net.minecraft.server.v1_12_R1.EntityInsentient;

import org.bukkit.entity.LivingEntity;

import com.matrix.pigmanoptimiser.ai.Control_Util_Main;

public class Control_Util implements Control_Util_Main
{

	@Override
	public void lookTicks(LivingEntity target, double x, double y, double z) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		if(t!=null)
			t.getControllerLook().a(x,y,z,10,40);
	}
	@Override
	public void setJump(LivingEntity target) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		if(t!=null)
			t.getControllerJump().a();
	}
	@Override
	public void doJump(LivingEntity target) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		if(t!=null)
			t.getControllerJump().b();
	}

	@Override
	public void setMoveTo(LivingEntity target, double x, double y, double z,double speed) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		if(t!=null)
			t.getControllerMove().a(x,y,z,speed);
	}
	@Override
	public void setYaw(LivingEntity target,float yaw) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		t.yaw=yaw;
	}
	@Override
	public void setPitch(LivingEntity target,float pitch) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		t.pitch=pitch;
	}
	@Override
	public void setX(LivingEntity target,double x)
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		t.locX=x;
	}
	@Override
	public void setY(LivingEntity target,double y) 
	{
		EntityInsentient t=new AI_Util().getHandle(target);
		t.locY=y;
	}
	@Override
	public void setZ(LivingEntity target,double z) 
	{

		EntityInsentient t=new AI_Util().getHandle(target);
		t.locZ=z;
	}

}
