package com.matrix.pigmanoptimiser.ai;

import com.matrix.pigmanoptimiser.ai.AIItem.AbstractAIItem;

import java.util.ArrayList;
import java.util.List;

public class AIList {
    public List<AbstractAIItem> aiLists =new ArrayList<AbstractAIItem>();
    public void addAI(AbstractAIItem ai){
        aiLists.add(ai);
    }
}
