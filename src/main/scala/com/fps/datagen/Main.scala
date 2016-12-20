package com.fps.datagen

import com.fps.datagen.event.{BattleEvent, SightingEvent}
import com.fps.datagen.generators.Generator
import com.fps.datagen.generators.geo.GeoGenerator
import com.fps.datagen.generators.pokemon.PokemonGenerator._
import com.fps.datagen.pokemon.Generations

import scala.util.Random

/* @author medge */

object Main extends App with JsonMultiFileWriter {

  val numRecords = 500
  val numFiles = 5

  val genFolder = "./gen"

  println(Generations.Generation1.exists(_.pokedexId == 73))

  // Creates JSON records
  val battleRecords =
    (0 to numRecords)
      .map(i => GeoGenerator.randomStateAndZip())
      .map { case (state, zip) => EventGenerator.randomBattleEvent(state, zip) }

  writePartFiles(battleRecords, numFiles, genFolder, "battles-")


  val sightingRecords =
    (0 to numRecords)
      .map(i => GeoGenerator.randomStateAndZip())
      .map { case (state, zip) => EventGenerator.randomSightingEvent(state, zip) }

  writePartFiles(sightingRecords, numFiles, genFolder, "sightings-")

}

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

  /**
   * Create a random Pokemon Sighting event
   *
   * @param state String
   * @param zip String
   * @return SightingEvent
   */
  def randomSightingEvent(state: String, zip: String, date: String = randomDate().toString): SightingEvent = {
    val pokemon = randomPokemon(1)

    SightingEvent(state, zip, date, pokemon.head)
  }
}
