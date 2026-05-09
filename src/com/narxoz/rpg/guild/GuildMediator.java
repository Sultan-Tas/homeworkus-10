package com.narxoz.rpg.guild;

/**
 * Central communication contract for guild colleagues.
 */
public interface GuildMediator {

    void register(GuildMember member);

    void dispatch(GuildTopic topic, GuildMember from, String payload);
}
