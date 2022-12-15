package it.bitrock.adventofcode2022

import scala.io.Source

class Day3 {
  def part1: Int = {
    val inputFile = Source.fromResource(Day3.file)
    val input = inputFile.mkString
    input.trim
      .split("\n")
      .toList
      .map(s => findItem(s))
      .map(i => calculatePriority(i))
      .sum
  }

  def findItem(inputLine: String): Char = {
    def doFind(parts: (String, String)): Char = {
      if (parts._2.contains(parts._1.head))
        parts._1.head
      else
        doFind(parts._1.tail, parts._2)
    }

    val mid = inputLine.length / 2
    val parts =
      (inputLine.substring(0, mid), inputLine.substring(mid))

    doFind(parts)
  }

  def calculatePriority(item: Char): Int = {
    if (item.isUpper)
      item.toInt - 38
    else
      item.toInt - 96
  }

}

object Day3 extends App {
  val file = "input-day3.txt"
  val day3 = new Day3

  println(s"Answer day3-part1: ${day3.part1}")
}
