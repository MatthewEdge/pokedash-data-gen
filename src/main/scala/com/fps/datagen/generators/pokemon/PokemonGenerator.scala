package com.fps.datagen.generators.pokemon

import java.util.UUID

import com.fps.datagen.generators.Generator
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
  def randomPokemon(n: Int, fromGeneration: Set[Pokemon] = Generations.Generation1): Set[Pokemon] = {
    val maxPokeId = 151
    val indexes = Seq.fill(n)(1 + Random.nextInt(maxPokeId)) // Between 1 and 151, inclusive

    // Fetch matching Pokemon from Gen 1 and assign a random level (1 to 80) to them before returning
    val pokemon = fromGeneration.filter(pokemon => indexes.contains(pokemon.pokedexId))

    if(pokemon.isEmpty) {
      println(s"Empty list generated from $indexes")
    }

    pokemon.map(_.copy(level = randomInt(1, 80)))
  }

}
