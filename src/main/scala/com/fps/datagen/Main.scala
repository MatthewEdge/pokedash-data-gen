package com.fps.datagen

import com.fps.datagen.event.{BattleEvent, SightingEvent}
import com.fps.datagen.generators.Generator
import com.fps.datagen.generators.geo.GeoGenerator
import com.fps.datagen.generators.pokemon.PokemonGenerator._

import scala.util.Random

/* @author medge */

object Main extends App with JsonMultiFileWriter {

  val numRecords = 500
  val numFiles = 5

  val genFolder = "./gen"

  // Creates JSON records
  val battleRecords =
    (0 until numRecords)
      .map(i => GeoGenerator.randomStateAndZip())
      .map { case (state, zip) => EventGenerator.randomBattleEvent(state, zip) }

  writePartFiles(battleRecords, numFiles, genFolder, "battles-")


  val sightingRecords =
    (0 until numRecords)
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
    val trainerB = randomTrainer()

    // Currently choose a random trainer. Needs to be a bit....smarter
    val victoriousTrainer = if(Random.nextInt(10) % 2 == 0) trainerA else trainerB

    BattleEvent(
      state,
      zip,
      randomDate().toString,
      victoriousTrainer,
      trainerA,
      trainerB
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
    val pokemon = randomPokemon(1).head

    SightingEvent(state, zip, date, pokemon)
  }
}
