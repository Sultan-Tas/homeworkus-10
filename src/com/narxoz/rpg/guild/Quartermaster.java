package com.narxoz.rpg.guild;

import java.util.List;

/**
 * Guild officer responsible for gear, supplies, and rewards.
 */
public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void requestSupplies(GuildTopic topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    protected List<GuildTopic> getSubscribedTopics() {
        return List.of(GuildTopic.ORDER, GuildTopic.HEALS, GuildTopic.ROUTE);
    }

    @Override
    public void receive(GuildTopic topic, GuildMember from, String payload) {
        System.out.printf("%n Q-Master[%s]► Received %s from %s \"%s\"", getName(), topic.toString().toLowerCase(), from.getName().toLowerCase(), payload);
    }
}
