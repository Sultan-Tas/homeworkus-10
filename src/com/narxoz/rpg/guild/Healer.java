package com.narxoz.rpg.guild;

import java.util.List;

/**
 * Guild officer responsible for wounds, potions, and recovery plans.
 */
public class Healer extends GuildMember {

    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void prepareAid(GuildTopic topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    protected List<GuildTopic> getSubscribedTopics() {
        return List.of(GuildTopic.ORDER, GuildTopic.SUPPLIES);
    }

    @Override
    public void receive(GuildTopic topic, GuildMember from, String payload) {
        System.out.printf("%n Healer[%s]► Received %s from %s \"%s\"", getName(), topic.toString().toLowerCase(), from.getName().toLowerCase(), payload);
    }
}
