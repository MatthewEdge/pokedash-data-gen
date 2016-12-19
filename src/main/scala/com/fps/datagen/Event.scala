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
  state: String,
  zipCode: String,
  ts: String, pokemon: Pokemon
) extends Event {

  val eventType: String = EventType.SIGHTING

}

case class BattleEvent(
  state: String,
  zipCode: String,
  ts: String,
  winner: Trainer,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event {

  val eventType: String = EventType.BATTLE

}

case class TradeEvent(
  state: String,
  zipCode: String,
  ts: String,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
) extends Event {

  val eventType: String = EventType.TRADE

}
