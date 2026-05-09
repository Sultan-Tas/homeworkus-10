package com.narxoz.rpg.guild;

import java.util.List;

/**
 * Guild officer responsible for orders and mission coordination.
 */
public class Captain extends GuildMember {

    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void issueOrder(GuildTopic topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    protected List<GuildTopic> getSubscribedTopics() {
        return List.of(GuildTopic.ORDER, GuildTopic.ROUTE, GuildTopic.HEALS, GuildTopic.SUPPLIES);
    }

    @Override
    public void receive(GuildTopic topic, GuildMember from, String payload) {
        System.out.printf("%n Captain[%s]► Received %s from %s \"%s\"", getName(), topic.toString().toLowerCase(), from.getName().toLowerCase(), payload);
    }
}
