package com.fps.datagen

import com.fps.datagen.battles.BattleEvent
import com.fps.datagen.pokemon.{PokeType, Pokemon}
import com.fps.datagen.trainer.Trainer

/**
 * @author medge
 */
object Main extends App with JsonSupport {

  val bulbasaur = Pokemon(1, "Bulbasaur", PokeType.Grass, PokeType.Poison, 1)
  val charmander = Pokemon(4, "Charmander", PokeType.Fire, 1)

  val trainerA = Trainer("123", "Medge", "M", 26, Set(bulbasaur))
  val trainerB = Trainer("456", "Ash", "M", 15, Set(charmander))

  println(writeJson(trainerA))
  println(writeJson(trainerB))

  val battle = BattleEvent(
    "North Carolina",
    "28277",
    trainerA.id,
    trainerA,
    trainerA.pokemon.head,
    trainerB,
    trainerB.pokemon.head
  )

  println(writePretty(battle))

}
