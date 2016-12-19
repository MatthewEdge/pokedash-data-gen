package com.fps.datagen.event

/* @author medge */

/**
 * An event that occurred at some point in time at some location
 */
trait Event {
  val eventType: String /* String */
  val state: String
  val zipCode: String
  val ts: String
}

object EventType {
  val BATTLE = "Battle"
  val TRADE = "Trade"
  val GYM_TAKEOVER = "Gym Takeover"
  val SIGHTING = "Sighting"
}
