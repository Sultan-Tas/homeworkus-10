package com.narxoz.rpg.guild;

import java.util.List;

/**
 * Guild officer responsible for route reports and reconnaissance.
 */
public class LoreMaster extends GuildMember {

    public LoreMaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void reportRoute(GuildTopic topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    protected List<GuildTopic> getSubscribedTopics() {
        return List.of(GuildTopic.ORDER, GuildTopic.ROUTE);
    }

    @Override
    public void receive(GuildTopic topic, GuildMember from, String payload) {
        System.out.printf("%n LoreMaster[%s]► Received %s from %s \"%s\"", getName(), topic.toString().toLowerCase(), from.getName().toLowerCase(), payload);
    }
}
