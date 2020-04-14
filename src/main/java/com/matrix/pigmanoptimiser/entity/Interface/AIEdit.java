package com.matrix.pigmanoptimiser.entity.Interface;

import com.matrix.pigmanoptimiser.manager.AIManager;

public interface AIEdit 
{
	public void removeAttackAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public AIManager getAIManager();
}
