package com.matrix.pigmanoptimiser.ai.AIItem.Special;

import com.matrix.pigmanoptimiser.ai.AIItem.AbstractAIItem;
import com.matrix.pigmanoptimiser.entity.MyEntity;

public class MoveTargetLocationAIItem extends AbstractAIItem
{
	private MyEntity target;
	public MoveTargetLocationAIItem(MyEntity target)
	{
		this.target=target;
	}
	@Override
	public boolean shouldExecute() 
	{
		if(!this.target.hasTargetLocation() || !this.target.isSpawned() || this.target.getBukkitEntity().isDead()) 
            return false;
		return true;
	}
	@Override
	public void startExecute()
	{
		this.target.getNavigation().navigationTo(this.target.getTargetLocation().getX(),this.target.getTargetLocation().getY(),this.target.getTargetLocation().getZ(),this.target.getSpeedToLocation());
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
