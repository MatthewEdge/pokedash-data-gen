package com.fps.datagen

import com.fps.datagen.generators.Generator
import com.fps.datagen.generators.geo.GeoGenerator

import scala.util.Random

/* @author medge */

/**
 *  Sample Event
 *
 *  {
 *    state: String,
 *    zipCode: String,
 *    ts: YYYY-mm-dd,
 *    type: String [Sighting, Battle, Trade, GymTakeover],
 *
 *    trainers: [
 *      {
 *        name: String,
 *        age: Int,
 *        gender: String [Male, Female],
 *        pokemon: [Pokemon, Pokemon, ...],
 *      },
 *
 *      ...
 *    ],
 *
 *    winner: Trainer, (or null if Trade)
 *    pokemon: Pokemon (Mostly for Sighting)
 *
 *  }
 *
 */
object Main extends App with FileSupport with JsonSupport {

  val numRecords = 5
  val outputFile = "./output.txt"

  // Creates JSON records
  lazy val jsonRecords =
    (0 to numRecords)
      .map(i => GeoGenerator.randomStateAndZip())
      .map { case (state, zip) => EventGenerator.randomBattleEvent(state, zip)}
      .map(writePretty[BattleEvent])

  write(outputFile, jsonRecords.mkString(",\n"))

}

object EventGenerator extends Generator {

  import com.fps.datagen.generators.PokemonGenerator._

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
      EventType.BATTLE,
      state,
      zip,
      victoriousTrainer,
      trainerA,
      pokemonA,
      trainerB,
      pokemonB
    )
  }

}
