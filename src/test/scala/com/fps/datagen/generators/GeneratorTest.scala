package com.fps.datagen.generators

import com.fps.datagen.BaseTest

/**
 * @author medge
 */
class GeneratorTest extends BaseTest {

  "randomInt()" should "generate a random integer of 0 or 1" in {
    val generator = new Generator {}

    val generatedInts = Seq.fill(10)(generator.randomInt())

    all(generatedInts) should(be > 0 or be < 1)
  }

  "randomItemFrom()" should "pick a random element in the given collection" in {
    val generator = new Generator {}

    val items = List(1,2,3,4,5)

    val randomItems = Seq.fill(10)(generator.randomItemFrom(items))

    randomItems.distinct.size should be > 1 // Don't generate the same item all the time?

    forAll(randomItems) { randItem => items should contain(randItem) }
  }

}
