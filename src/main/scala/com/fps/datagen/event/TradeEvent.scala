package com.fps.datagen.event

import com.fps.datagen.pokemon.Pokemon
import com.fps.datagen.trainer.Trainer

/* @author medge */

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
