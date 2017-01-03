package com.fps.datagen

import java.io.File

/* @author medge */

/**
 * Write entries out to multiple files, serialized as JSON
 */
trait JsonMultiFileWriter extends FileSupport with JsonSupport {

  def writePartFiles[T <: AnyRef : Manifest](entries: Seq[T], nFiles: Int, basePath: String, namePrefix: String): Unit = {

    val groupSize = entries.size / nFiles
    val groups = entries.grouped(groupSize).toList

    // Ensure basePath exists on the filesystem
    val baseFilePath = new File(basePath)
    if(!baseFilePath.exists()) {
      baseFilePath.mkdirs()
    }

    val filePaths = (0 to nFiles).map(i => s"$basePath/$namePrefix$i.json")

    // Map each part file to a group of records and write out to a file
    filePaths.zip(groups).foreach {
      case (path, group) => {
        val groupJson = writePretty[Seq[T]](group)

        println(s"Writing ${group.size} records to $path")

        write(path, groupJson)
      }
    }
  }

}
