package com.fps.datagen.event

import com.fps.datagen.pokemon.Pokemon

/* @author medge */

case class SightingEvent(
  state: String,
  zipCode: String,
  ts: String,
  pokemon: Pokemon
) extends Event {

  val eventType: String = EventType.SIGHTING

}
