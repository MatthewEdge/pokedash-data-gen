package com.fps.datagen

import com.fps.datagen.pokemon.Pokemon
import com.fps.datagen.trainer.Trainer

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

case class SightingEvent(
  eventType: String = EventType.SIGHTING,
  state: String,
  zipCode: String,
  ts: String,
  pokemon: Pokemon
) extends Event

case class BattleEvent(
  eventType: String = EventType.BATTLE,
  state: String,
  zipCode: String,
  ts: String,
  winner: Trainer,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event

case class TradeEvent(
  eventType: String = EventType.TRADE,
  state: String,
  zipCode: String,
  ts: String,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event
