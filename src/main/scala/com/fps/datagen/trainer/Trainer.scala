package com.fps.datagen.trainer

import com.fps.datagen.pokemon.Pokemon

/* @author medge */

case class Trainer(
  name: String,
  gender: String,
  age: Int,
  pokemon: Set[Pokemon]
)
