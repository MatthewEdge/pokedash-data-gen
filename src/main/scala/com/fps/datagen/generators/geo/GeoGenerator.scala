package com.fps.datagen.generators.geo

import com.fps.datagen.generators.Generator
import com.fps.datagen.{FileSupport, JsonSupport}

import scala.util.Random

/* @author medge */

/**
 * Geographic Data Generator.
 *
 * NOTE:
 *    Expects a JSON file called 'zipcodes.json' to exist in the resources directory (src/main/resources)
 */
object GeoGenerator extends Generator with FileSupport with JsonSupport {

  lazy val zipcodes: List[ZipCode] = {
    val zipcodesJson = readResourceFile("/zipcodes.json").mkString("\n")

    readJson[List[ZipCode]](zipcodesJson)
  }

  // States and Abbreviations
  val states = List(
    ("Alabama", "AL"),
    ("Alaska", "AK"),
    ("Arizona", "AZ"),
    ("Arkansas", "AR"),
    ("California", "CA"),
    ("Colorado", "CO"),
    ("Connecticut", "CT"),
    ("Delaware", "DE"),
    ("Florida", "FL"),
    ("Georgia", "GA"),
    ("Hawaii", "HI"),
    ("Idaho", "ID"),
    ("Illinois", "IL"),
    ("Indiana", "IN"),
    ("Iowa", "IA"),
    ("Kansas", "KS"),
    ("Kentucky", "KY"),
    ("Louisiana", "LA"),
    ("Maine", "ME"),
    ("Maryland", "MD"),
    ("Massachusetts", "MA"),
    ("Michigan", "MI"),
    ("Minnesota", "MN"),
    ("Mississippi", "MS"),
    ("Missouri", "MO"),
    ("Montana", "MT"),
    ("Nebraska", "NE"),
    ("Nevada", "NV"),
    ("New Hampshire", "NH"),
    ("New Jersey", "NJ"),
    ("New Mexico", "NM"),
    ("New York", "NY"),
    ("North Carolina", "NC"),
    ("North Dakota", "ND"),
    ("Ohio", "OH"),
    ("Oklahoma", "OK"),
    ("Oregon", "OR"),
    ("Pennsylvania", "PA"),
    ("Rhode Island", "RI"),
    ("South Carolina", "SC"),
    ("South Dakota", "SD"),
    ("Tennessee", "TN"),
    ("Texas", "TX"),
    ("Utah", "UT"),
    ("Vermont", "VT"),
    ("Virginia", "VA"),
    ("Washington", "WA"),
    ("West Virginia", "WV"),
    ("Wisconsin", "WI"),
    ("Wyoming", "WY")
  )

  /**
   * @return a random (State Name, State Abbreviation) tuple
   */
  def randomState(): (String, String) = {
    randomItemFrom(states)
  }

  /**
   * @return a random US state name
   */
  def randomStateName(): String = {
    randomState()._1
  }

  /**
   * @return a random US state abbreviation
   */
  def randomStateAbbreviation(): String = {
    randomState()._2
  }

  /**
   * @param stateAbbrev String State abbreviation
   * @return String random zip code for the given state
   */
  def randomZipCodeFor(stateAbbrev: String): String = {
    val zipsForState = zipcodes.filter(_.state == stateAbbrev)

    Random.shuffle(zipsForState).map(_.zip).head
  }

  /**
   * @return (String, String) state abbreviation, zipcode within that state
   */
  def randomStateAndZip(): (String, String) = {
    val stateAbbrev = randomStateAbbreviation()

    (stateAbbrev, randomZipCodeFor(stateAbbrev))
  }

}
