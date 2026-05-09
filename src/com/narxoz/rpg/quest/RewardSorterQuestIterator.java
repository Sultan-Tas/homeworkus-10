package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverses quests in arrival order.
 */
public class RewardSorterQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int cursor;

    public RewardSorterQuestIterator(QuestLog questLog, int threshold) {
        this.snapshot = new ArrayList<>();
        for(Quest quest : questLog.snapshot()){
            if(quest.getRewardGold() >= threshold){
                snapshot.add(quest);
            }
        }
        this.cursor = 0;
    }



    @Override
    public boolean hasNext() {
        return cursor < snapshot.size();
    }

    @Override
    public Quest next() {
        return snapshot.get(cursor++);
    }
}
