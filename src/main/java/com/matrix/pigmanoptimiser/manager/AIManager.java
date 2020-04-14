package com.matrix.pigmanoptimiser.manager;

import java.util.List;

import javax.annotation.Nullable;

import com.matrix.pigmanoptimiser.PigmanOptimiser;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.matrix.pigmanoptimiser.ai.AIItem.AbstractAIItem;



public class AIManager 
{
	final private LivingEntity targetEntity; 
	public AIManager(LivingEntity le)
	{
		this.targetEntity=le;
	}
	public LivingEntity getTarget()
	{
		return this.targetEntity;
	}
	public void killAttackAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		PigmanOptimiser.nms_ai.KillTargetSelector(this.targetEntity);
	}
	public void killAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		PigmanOptimiser.nms_ai.KillGoalSelector(this.targetEntity);
	}
	public void setAI(List<AbstractAIItem> list) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(AbstractAIItem p:list)
			PigmanOptimiser.nms_ai.addAItoGoalSelector(this.targetEntity,p);
	}
	public void setTargetAI(List<AbstractAIItem> list) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(AbstractAIItem p:list)
			PigmanOptimiser.nms_ai.addAItoTargetSelector(this.targetEntity,p);
	}
	public void addAI(AbstractAIItem item,int prop)
	{
		PigmanOptimiser.nms_ai.addAItoGoalSelector(this.targetEntity,item, prop);
	}
	public void addTargetAI(AbstractAIItem item,int prop)
	{
		PigmanOptimiser.nms_ai.addAItoTargetSelector(this.targetEntity,item, prop);
	}
	public void setAI(boolean b)
	{
		this.targetEntity.setAI(b);
	}
	public void setGoalTarget(@Nullable LivingEntity e)
	{
		PigmanOptimiser.nms_ai.setGoalTarget(this.targetEntity,e,TargetReason.CUSTOM);
	}
	public void setGoalTarget(@Nullable LivingEntity e,TargetReason reason)
	{
		PigmanOptimiser.nms_ai.setGoalTarget(this.targetEntity,e,reason);
	}
	public Entity getGoalTarget()
	{
		return PigmanOptimiser.nms_ai.getGoalTarget(this.targetEntity);
	}
	public void addRevengeTargetSelector(int prop)
	{
		PigmanOptimiser.nms_ai.addRevengeTargetSelector(this.targetEntity,prop);
	}
	public int getLastDamageTicks()
	{
		return PigmanOptimiser.nms_ai.getLastDamageTicks(this.targetEntity);
	}
	public boolean addFleeSunAI(double speed,int prop)
	{
		return PigmanOptimiser.nms_ai.addFleeSunAI(this.targetEntity,speed,prop);
	}
	public boolean addMeleeAttackAI(double speed,boolean flag,int prop)
	{
		return PigmanOptimiser.nms_ai.addMeleeAttackAI(this.targetEntity,speed,flag,prop);
	}
	public boolean addOpenDoorAI(boolean flag,int prop)
	{
		return PigmanOptimiser.nms_ai.addOpenDoorAI(this.targetEntity,flag,prop);
	}
	public boolean addBreakDoorAI(int prop)
	{
		return PigmanOptimiser.nms_ai.addBreakDoorAI(this.targetEntity,prop);
	}
}
