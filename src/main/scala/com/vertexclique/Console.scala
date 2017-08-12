package com.vertexclique

import fansi.Color

trait Console {
  def warning(msg: String): Unit = println(Color.Yellow(msg))
  def error(msg: String): Unit = println(Color.Red(msg))
  def info(msg: String): Unit = println(Color.LightCyan(msg))

  def data(msg: String): Unit = println(Color.LightBlue(msg))
}
