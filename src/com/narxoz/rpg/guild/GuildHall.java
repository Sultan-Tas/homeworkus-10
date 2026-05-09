package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Topic-based mediator for the Adventurers' Guild war council.
 */
public class GuildHall implements GuildMediator {

    private final Map<GuildTopic, List<GuildMember>> membersByTopic = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        for(GuildTopic topic : member.getSubscribedTopics()){
            addSubscriber(topic, member);
        }
    }

    @Override
    public void dispatch(GuildTopic topic, GuildMember from, String payload) {
        int i = 0;
        for(GuildMember member : membersByTopic.get(topic)) {
            if(member != from){
                i++;
                member.receive(topic, from, payload);
            }
        }
        System.out.println("► " + from.getName() + " notified " + i + " members");
    }

    protected void addSubscriber(GuildTopic topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(GuildTopic topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}
