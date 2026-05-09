package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Orchestrates a planning session that uses both Iterator and Mediator.
 */
public class CouncilEngine {

    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {
        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 4;

        //establishing members
        Captain captain = new Captain("Smollet", hall);
        Scout scout = new Scout("Jimmy", hall);
        Healer healer = new Healer("Livesey", hall);
        Quartermaster quartermaster = new Quartermaster("Trelony", hall);
        LoreMaster loreMaster = new LoreMaster("Seer", hall);
        List<GuildMember> members = new ArrayList<>();
        members.add(captain);
        members.add(scout);
        members.add(healer);
        members.add(quartermaster);
        members.add(loreMaster);


        System.out.println("= Iterator Demo =");
        System.out.println("\n►Questlog with Ordered◄");
        QuestIterator ordered = questLog.ordered();
        while(ordered.hasNext()) {
            questsTraversed++;
            System.out.println("→ " + ordered.next());
        }

        QuestPriority type = QuestPriority.HIGH;
        System.out.println("\n►Questlog with " + type + " Priority sort◄");
        QuestIterator priority = questLog.priorityAtLeast(type);
        while(priority.hasNext()) {
            questsTraversed++;
            System.out.println("→ " + priority.next());
        }

        int minimum = 150;
        System.out.println("\n►Questlog with Reward at least" + minimum +  " ◄");
        QuestIterator reward = questLog.rewardAtLeast(minimum);
        while (reward.hasNext()) {
            questsTraversed++;
            System.out.println("→ " + reward.next());
        }

        System.out.println("= Mediator Demo =");

        captain.issueOrder(GuildTopic.ORDER, "Move out at dawn!");
        messagesRouted++;
        scout.reportRoute(GuildTopic.ROUTE, "We will move through the ravine");
        messagesRouted++;
        healer.prepareAid(GuildTopic.HEALS, "Gather for healing!");
        messagesRouted++;

        membersNotified = members.size();
        return new CouncilRunResult(questsTraversed, messagesRouted, membersNotified);
    }
}
