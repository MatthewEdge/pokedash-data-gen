package com.fps.datagen

import com.fps.datagen.generators.events.EventGenerator
import com.fps.datagen.generators.geo.GeoGenerator

/* @author medge */

object Main extends App with JsonMultiFileWriter {

  val numRecords = 500

  // Creates JSON records
  lazy val jsonRecords =
    (0 to numRecords)
      .map(i => GeoGenerator.randomStateAndZip())
      .map { case (state, zip) => EventGenerator.randomBattleEvent(state, zip)}

  writePartFiles(jsonRecords, 5, "./gen", "battles")

}
