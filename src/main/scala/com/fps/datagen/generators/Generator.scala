package com.fps.datagen.generators

import java.time.LocalDate

import scala.util.Random

/* @author medge */

/**
 * Base Generator Class. Mix in desired traits when creating instances to include other generator types
 */
abstract class Generator {

  /**
   * Generate a random integer
   *
   * @param lower Lower bound for random age. Default: 0
   * @param upper Upper bound for random age. Default: 1
   * @return Int between lower and upper, inclusive
   */
  def randomInt(lower: Int = 0, upper: Int = 1): Int = {
    lower + Random.nextInt(upper + 1)
  }

  /**
   * Generate a random long integer
   *
   * @param lower Long Lower bound for random age. Default: 0
   * @param upper Long Upper bound for random age. Default: 1
   * @return Long between lower and upper, inclusive
   */
  def randomLong(lower: Long = 0, upper: Long = 1): Long = {
    lower + Random.nextLong() % upper
  }

  def randomDate(): LocalDate = {
    val minDate = LocalDate.of(1970, 1, 1).toEpochDay
    val maxDate = LocalDate.now().toEpochDay

    val randomDay = randomLong(minDate, maxDate)

    LocalDate.ofEpochDay(randomDay)
  }

  /**
   * Select and return a random item from the given collection
   *
   * @param coll Traversable[T] collection to choose from
   * @tparam T Item types
   * @return T random item from the collection
   * @throws RuntimeException if the given collection is empty
   */
  @throws[RuntimeException]
  def randomItemFrom[T](coll: Traversable[T]): T = {
    if(coll.isEmpty)
      throw new RuntimeException("Collection cannot be empty!")

    Random.shuffle(coll).head
  }
}
