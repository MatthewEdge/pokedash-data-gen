package com.fps.datagen

import java.io.FileNotFoundException

/* @author medge */

trait FileSupport {

  /**
   * Read a file from src/main/resources into a List[String]
   *
   * @param path relative path to src/main/resources
   * @return List[String] lines of the found file
   * @throws FileNotFoundException if path cannot be resolved to a file
   */
  def readResourceFile(path: String): List[String] = {
    Option(getClass.getResourceAsStream(path))
      .map(scala.io.Source.fromInputStream)
      .map(_.getLines.toList)
      .getOrElse(throw new FileNotFoundException(path))
  }

}
