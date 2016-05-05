package com.homework.chapter1;


import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas Battiato on 4/5/2016.
 */
public class Actor1Test {
    ActorSystem system = ActorSystem.create();


    @Test
    public void testMessageReceivedCorrectly() throws Exception {
        String msg = "helloAkka";
        TestActorRef<Actor1> actorRef = TestActorRef.create(system, Props.create(Actor1.class));
        actorRef.tell(msg, ActorRef.noSender());
        Actor1 actor1 = actorRef.underlyingActor();
        assertEquals(actor1.message.getMessage(),msg);
    }

    @Test
    public void testItBehavesWellWithTwoMessages() throws Exception {
        String msg1 = "helloAkka";
        String msg2 = "goodbyeAkka";
        TestActorRef<Actor1> actorRef = TestActorRef.create(system, Props.create(Actor1.class));
        actorRef.tell(msg1, ActorRef.noSender());
        Actor1 actor1 = actorRef.underlyingActor();
        assertEquals(actor1.message.getMessage(),msg1);
        actorRef.tell(msg2,ActorRef.noSender());
        actor1 = actorRef.underlyingActor();
        assertEquals(actor1.message.getMessage(),msg2);

    }
}