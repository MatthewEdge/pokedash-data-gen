package com.fps.datagen.generators

import java.util.UUID

import com.fps.datagen.pokemon.{Generations, Pokemon}
import com.fps.datagen.trainer.Trainer

import scala.util.Random

/* @author medge */

object PokemonGenerator extends Generator {

  def randomTrainer(): Trainer = {
    Trainer(
      UUID.randomUUID().toString, // TODO change to name generator
      randomGender(),
      randomInt(15, 80),
      randomPokemon(6)
    )
  }

  /**
   * @return String "M" if a randomly generated integer is even. "F" if it is odd
   */
  def randomGender(): String = {
    if(Random.nextInt(10) % 2 == 0) "M" else "F"
  }

  /**
   * Generate a Set of n random Pokemon
   *
   * @param n Int number of random Pokemon to generate
   * @return Set[Pokemon]
   */
  def randomPokemon(n: Int): Set[Pokemon] = {
    val maxPokeId = 151
    val indexes = Seq.fill(n)(1 + Random.nextInt(maxPokeId + 1)) // Between 1 and 151, inclusive

    // Fetch matching Pokemon from Gen 1 and assign a random level (1 to 80) to them before returning
    Generations.Generation1
      .filter(pokemon => indexes.contains(pokemon.pokedexId))
      .map(_.copy(level = randomInt(1, 80)))
  }

}
