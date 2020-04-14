package com.matrix.pigmanoptimiser.ai.AIItem.Special;


import com.matrix.pigmanoptimiser.ai.AIItem.AbstractAIItem;
import com.matrix.pigmanoptimiser.entity.MyEntity;
import com.matrix.pigmanoptimiser.manager.NavigationManager;

public class FollowTargetAIItem extends AbstractAIItem
{
	private double speed;
	private MyEntity entity; 
	public FollowTargetAIItem(MyEntity t,double speed)
	{
		this.speed=speed;
		this.entity=t;
	}
	@Override
	public boolean shouldExecute() 
	{
		return this.entity.isSpawned() && entity.hasFollowTarget() && entity.getFollowTarget().getWorld().equals(this.entity.getBukkitEntity().getWorld()) && this.entity.getBukkitEntity().isValid() && this.entity.getFollowTarget().isValid();
	}
	@Override
	public void startExecute()
	{
		NavigationManager nm=new NavigationManager(entity.getBukkitEntity());
		nm.navigationTo(this.entity.getFollowTarget().getLocation().getX(),this.entity.getFollowTarget().getLocation().getY(),this.entity.getFollowTarget().getLocation().getZ(),speed);
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
	@Override
	public void upDate()
	{
		this.startExecute();
	}
}
