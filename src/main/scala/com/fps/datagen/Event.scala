package com.fps.datagen

import java.time.LocalDateTime

import com.fps.datagen.pokemon.Pokemon
import com.fps.datagen.trainer.Trainer

/* @author medge */

/**
 * An event that occurred at some point in time at some location
 */
trait Event {
  val eventType: EventType.Value
  val state: String
  val zipCode: String
  val ts: LocalDateTime = LocalDateTime.now()
}

object EventType extends Enumeration {
  val BATTLE = Value("Battle")
  val TRADE = Value("Trade")
  val GYM_TAKEOVER = Value("Gym Takeover")
  val SIGHTING = Value("Sighting")
}

case class SightingEvent(
  eventType: EventType.Value = EventType.SIGHTING,
  state: String,
  zipCode: String,
  pokemon: Pokemon
) extends Event

case class BattleEvent(
  eventType: EventType.Value = EventType.BATTLE,
  state: String,
  zipCode: String,
  winner: Trainer,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event

case class TradeEvent(
  eventType: EventType.Value = EventType.TRADE,
  state: String,
  zipCode: String,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event

case class GymTakeoverEvent(
  eventType: EventType.Value = EventType.GYM_TAKEOVER,
  state: String,
  zipCode: String
) extends Event
