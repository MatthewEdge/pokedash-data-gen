package com.fps.datagen

import java.io.FileNotFoundException

/**
 * @author medge
 *
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
 *
 *
 */
object Main extends App with JsonSupport {

  def readResourceFile(p: String) = {
    Option(getClass.getResourceAsStream(p)).map(scala.io.Source.fromInputStream)
      .map(_.getLines.toList)
      .map(_.mkString("\n"))
      .getOrElse(throw new FileNotFoundException(p))
  }

  val zipcodesJson = readResourceFile("/zipcodes.json")
  val zipcodes = readJson[ZipCodeData](zipcodesJson).zipcodes

  println(zipcodes.head.state)
}

case class ZipCodeData(
  zipcodes: List[ZipCode]
)

/**
 * {"zip":"10001","latitude":40.71,"longitude":-73.99,"city":"New York","state":"NY"}
 */
case class ZipCode(
  zip: String,
  latitude: Double,
  longitude: Double,
  city: String,
  state: String
)

//object TrainerGenerator extends Generator with GeoGenerator {
//
//  /**
//   * Generate a random BattleEvent between two given Trainers. All other details (location, winner, etc)
//   * are random
//   *
//   * @param trainerA Trainer
//   * @param trainerB Trainer
//   * @return BattleEvent
//   */
//  def createRandomBattleBetween(trainerA: Trainer, trainerB: Trainer): BattleEvent = {
//
//    val pokemonA = trainerA.pokemon.head
//    val pokemonB = trainerB.pokemon.head
//
//    // Either select by highest level pokemon, or random if levels are equal
//    val victoriousTrainerId = {
//      if(pokemonA.level > pokemonB.level)
//        trainerA.id
//      else if(pokemonA.level < pokemonB.level)
//        trainerB.id
//      else
//        Random.shuffle(List(trainerA.id, trainerB.id)).head
//
//    }
//
//    BattleEvent(
//      randomStateName(),
//      "",     // TODO after efficient zipCode generator added
//      victoriousTrainerId,
//      trainerA, trainerA.pokemon.head,
//      trainerB, trainerB.pokemon.head
//    )
//  }
//
//  def randomTrainer(): Trainer = {
//    Trainer(
//      UUID.randomUUID().toString,
//      randomGender(),
//      randomInt(15, 80),
//      randomPokemon(6)
//    )
//  }
//
//  /**
//   * @return String "M" if a randomly generated integer is even. "F" if it is odd
//   */
//  def randomGender(): String = {
//    if(Random.nextInt(10) % 2 == 0) "M" else "F"
//  }
//
//  /**
//   * Generate a Set of n random Pokemon
//   *
//   * @param n Int number of random Pokemon to generate
//   * @return Set[Pokemon]
//   */
//  def randomPokemon(n: Int): Set[Pokemon] = {
//    val maxPokeId = 151
//    val indexes = Seq.fill(n)(1 + Random.nextInt(maxPokeId + 1)) // Between 1 and 151, inclusive
//
//    // Fetch matching Pokemon from Gen 1 and assign a random level (1 to 80) to them before returning
//    Generations.Generation1
//      .filter(pokemon => indexes.contains(pokemon.pokedexId))
//        .map(_.copy(level = randomInt(1, 80)))
//  }
//
//}
