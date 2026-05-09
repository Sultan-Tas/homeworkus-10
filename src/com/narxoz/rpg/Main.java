package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;

/**
 * Entry point for Homework 10 — The Adventurers' Guild: Iterator + Mediator.
 *
 * The scaffold prints the banner only; students fill in the guild demo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");
        Hero Asgor = new Hero("Asgor", 500, 100, 60);
        Hero Sans = new Hero("Sans", 1, 1, 1);

        
        // 1. Create at least 2 heroes.
        // 2. Build a QuestLog with at least 5 quests of mixed priority.
        // 3. Register at least 4 GuildMembers (Quartermaster, Scout, Healer, Captain) on the GuildHall.
        // 4. Iterate the quest log with at least 2 different QuestIterator implementations.
        // 5. Dispatch coordinating messages through the mediator during quest planning.
        // 6. Run the CouncilEngine and print a final CouncilRunResult.
    }
}
