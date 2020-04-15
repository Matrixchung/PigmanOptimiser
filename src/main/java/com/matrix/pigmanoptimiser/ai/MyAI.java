package com.matrix.pigmanoptimiser.ai;

import com.matrix.pigmanoptimiser.ai.AIItem.AbstractAIItem;

public class MyAI extends AbstractAIItem {
    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void startExecute() {
        super.startExecute();
    }

    @Override
    public boolean continueExecute() {
        return false;
    }

    @Override
    public void upDate() {
        //super.upDate();
    }

    @Override
    public void resetAI() {
        super.resetAI();
    }
}
