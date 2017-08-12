package com.vertexclique.parser

import com.vertexclique.data.Node

import scala.io.Source
import fastparse.all._

class MainParser(data: String) {
  val ROW_DELIMITER = "->"
  val strChars      = P( CharsWhile(_ != ' ').! )
  val digits        = P( CharsWhileIn("0123456789"))

  def leafName = P("-> ") ~ P( strChars ~ &( " " ) ).!
  def typeName = P( " " ) ~ P( strChars ~/ &( " class" ) ).!
  def className = P( " class " ) ~ P( strChars ~/ &( " status=" ) ).!
  def status = (P( " status=" ) ~ P( digits ~/ &( " " ) ).!).map(_.toInt)
  def childrenCount = (P( " " ) ~ P( ("no" | digits) ~/ &( " children" ) ).!).map { elem =>
    if (elem == "no") {
      0
    } else {
      elem.toInt
    }
  }
  def node = P(leafName ~ typeName ~ className ~ status ~ childrenCount)

  def makeRow(line: String): String = ROW_DELIMITER ++ line.split(ROW_DELIMITER).last
  def parseAll = node.parse(makeRow(data))
}

object MainParser {
  def apply(data: String): MainParser = new MainParser(data)
}

class TreeParser{



  def assembleTree(tree: String): String = {
    val stream = Source.fromString(tree).getLines().takeWhile(_ != "").toSeq
    stream.foreach { (line: String) =>
      MainParser(line).parseAll match {
        case Parsed.Success(data, _) =>
          val node = Node.tupled(data)
          println(
            data,
            data.toString().length)

          println(node)
          println(node.name)
          println(node.`type`)
          println(node.`class`)
          println(node.status)
          println(node.children)
        case Parsed.Failure(msg, i, _) => println("FAILURE: " + msg + " INDEX " + i.toString)
      }
    }
    ""
  }
}
