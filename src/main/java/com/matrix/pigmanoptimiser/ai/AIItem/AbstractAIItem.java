package com.matrix.pigmanoptimiser.ai.AIItem;

public abstract class AbstractAIItem 
{
	abstract public boolean shouldExecute();
	public void startExecute()
	{
		
	}
	public boolean continueExecute()
	{
		return false;
	}
	public void upDate() 
	{
		
	}
	public void resetAI()
	{
		
	}
}
