package com.fps.datagen

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization

/**
 * JSON Helper class using json4s Native
 *
 * @author medge
 */
trait JsonSupport {

  implicit lazy val formats = DefaultFormats

  def writeJson[T <: AnyRef : Manifest](t: T): String = {
    Serialization.write[T](t)
  }

  def writePretty[T <: AnyRef : Manifest](t: T): String = {
    Serialization.writePretty[T](t)
  }

  def readJson[T <: AnyRef : Manifest](json: String): T = {
    parse(json).extract[T]
  }
}
