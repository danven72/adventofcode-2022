package it.bitrock

import scala.io.Source

package object adventofcode2022 {

  def extractListFromFile(inputFilename: String): List[String] = {
    val inputFile = Source.fromResource(inputFilename)
    inputFile.mkString.trim
      .split("\n")
      .toList
  }
}
