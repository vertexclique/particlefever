package com.vertexclique

import akka.actor.ActorSystem
import com.vertexclique.data.BTree

import scala.io.Source

class ParticleFever(system: ActorSystem) extends Console {
  private val resolver: PrivateMethodExposer = new PrivateMethodExposer(system)

  def getTree: Any = resolver('printTree)()

  def printTree = data(getTree.toString)
}

object ParticleFever {
  def apply()(implicit system: ActorSystem): ParticleFever = new ParticleFever(system)
}
