package com.narxoz.rpg.quest;

import java.util.List;

/**
 * Traverses quests in arrival order.
 */
public class RewardSorterQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int cursor;

    public RewardSorterQuestIterator(QuestLog questLog) {
        this.snapshot = questLog.snapshot();
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
