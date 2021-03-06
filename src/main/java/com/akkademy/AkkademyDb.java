package com.akkademy;

import java.util.HashMap;
import java.util.Map;

import com.akkademy.messages.SetRequest;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by Nicolas Battiato on 2/5/2016.
 */

public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    private AkkademyDb() {
        receive(ReceiveBuilder.match(SetRequest.class, message -> {
                    log.info("Received set request - key: {} value: {}", message.getKey(), message.getValue());
                    map.put(message.getKey(), message.getValue());
                }).matchAny(o -> log.info("Received unknown message {}", o)).build()
        );

    }

}
