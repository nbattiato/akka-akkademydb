package com.homework.chapter1;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by Nicolas Battiato on 4/5/2016.
 */
public class Actor1 extends AbstractActor{
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    public final Message message = new Message();

    private Actor1(){
        receive(ReceiveBuilder.match(String.class, message -> {
                    log.info("Received message : {}", message);
                    this.message.setMessage(message);
                }).matchAny(o -> log.info("Received unknown message {}", o)).build()
        );

    }

    public Message getMessage() {
        return message;
    }
}
