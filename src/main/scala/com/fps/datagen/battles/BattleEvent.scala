package com.fps.datagen.battles

import com.fps.datagen.pokemon.Pokemon
import com.fps.datagen.trainer.Trainer

/**
 * Battle event models
 *
 * @author medge
 */
case class BattleEvent(
  state: String,
  zipCode: String,
  winnerTrainerId: String,
  trainerA: Trainer,
  pokemonA: Pokemon,
  trainerB: Trainer,
  pokemonB: Pokemon
)