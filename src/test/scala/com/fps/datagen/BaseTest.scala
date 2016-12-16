package com.fps.datagen

import org.scalatest._

/**
 * Base test class to be inherited by all Test classes. Mixes in necessary test traits
 *
 * @author medge
 */
abstract class BaseTest extends FlatSpec
  with Matchers with Inspectors
  with BeforeAndAfter with BeforeAndAfterAll
