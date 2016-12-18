package com.fps.datagen.generators

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
