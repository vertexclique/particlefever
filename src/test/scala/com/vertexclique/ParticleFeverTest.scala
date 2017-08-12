package com.vertexclique

import java.io.ByteArrayOutputStream

import akka.actor.{ActorSystem, Props}
import akka.testkit.TestActors.ForwardActor
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.FlatSpecLike

class ParticleFeverTest extends TestKit(ActorSystem("PFActorSystem")) with FlatSpecLike {
  behavior of "Particle Fever"

  it should "print tree of actor system hierarchy" in {
    implicit val system = ActorSystem()
    val testProbe = TestProbe()
    system.actorOf(Props(classOf[ForwardActor], testProbe.ref))

    val stream = new ByteArrayOutputStream()
    Console.withOut(stream) {

    }

    ParticleFever().printTree
  }
}
