package com.fps.datagen.generators.events

import com.fps.datagen.event.BattleEvent
import com.fps.datagen.generators.Generator
import com.fps.datagen.generators.pokemon.PokemonGenerator._

import scala.util.Random

/* @author medge */

object EventGenerator extends Generator {

  /**
   * Create a random Pokemon Battle event at the given location
   *
   * @param state String
   * @param zip String
   * @return BattleEvent
   */
  def randomBattleEvent(state: String, zip: String): BattleEvent = {
    val trainerA = randomTrainer()
    val pokemonA = trainerA.pokemon.head

    val trainerB = randomTrainer()
    val pokemonB = trainerB.pokemon.head

    // Either select by highest level pokemon, or random if levels are equal
    val victoriousTrainer = {
      if(pokemonA.level > pokemonB.level)
        trainerA
      else if(pokemonA.level < pokemonB.level)
        trainerB
      else
        Random.shuffle(List(trainerA, trainerB)).head

    }

    BattleEvent(
      state,
      zip,
      randomDate().toString,
      victoriousTrainer,
      trainerA,
      pokemonA,
      trainerB,
      pokemonB
    )
  }

}