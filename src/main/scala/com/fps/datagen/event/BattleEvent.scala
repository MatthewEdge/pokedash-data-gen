package com.fps.datagen.event

import com.fps.datagen.trainer.Trainer

/* @author medge */

case class BattleEvent(
  state: String,
  zipCode: String,
  ts: String,
  winner: Trainer,
  trainerA: Trainer,
  trainerB: Trainer
) extends Event {

  val eventType: String = EventType.BATTLE

}
