package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for Homework 10 — The Adventurers' Guild: Iterator + Mediator.
 *
 * The scaffold prints the banner only; students fill in the guild demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        //creating heroes
        Hero Asgor = new Hero("Asgor", 500, 100, 60);
        Hero Sans = new Hero("Sans", 1, 1, 1);
        System.out.println(Asgor);
        System.out.println(Sans);
        System.out.println("= heroes created =");

        //creating quests
        QuestLog questlog = new QuestLog();
        questlog.add(new Quest("Clean the pavement", QuestPriority.LOW, 20, false));
        questlog.add(new Quest("Kill Monster", QuestPriority.HIGH, 200, false));
        questlog.add(new Quest("Clean the pavement", QuestPriority.LOW, 15, false));
        questlog.add(new Quest("Reduce wolf population", QuestPriority.NORMAL , 70, false));
        questlog.add(new Quest("Protect the island from Pirates", QuestPriority.URGENT, 500, true));
        questlog.add(new Quest("Cut the yard", QuestPriority.LOW, 30, false));
        System.out.println("=Quest log created with " + questlog.size() + " quests =");


        //creating mediator
        GuildMediator guildhall = new GuildHall();
        System.out.println("\n= Mediator are created =");

        //creating and filling the party
        List<Hero> guildMembers = new ArrayList<>();
        guildMembers.add(Asgor);
        guildMembers.add(Sans);

        //creating engine and running it
        System.out.println("\nRunning the CouncilEngine");
        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(guildMembers, questlog ,guildhall);
        System.out.println("Quests traversed: " + result.getQuestsTraversed());
        System.out.println("Messages routed: " + result.getMessagesRouted());
        System.out.println("members notified: " + result.getMembersNotified());
    }
}
