package it.bitrock.adventofcode2022

import scala.io.Source

class Day1 {

  def part1: Int = {
    val inputFile = Source.fromResource(Day1.file)
    val input = inputFile.mkString
    input.trim
      .split("\n\n")
      .toList
      .map(
        _.split("\n")
          .map(_.toInt)
          .sum
      )
      .max
  }

  def part2: Int = {
    val inputFile = Source.fromResource(Day1.file)
    val input = inputFile.mkString
    input.trim
      .split("\n\n")
      .toList
      .map(
        _.split("\n")
          .map(_.toInt)
          .sum
      )
      .sortWith(_ > _)
      .slice(0, 3)
      .sum
  }

}

object Day1 extends App {
  private val file = "input-day1.txt"

  val day1 = new Day1
  println(s"Answer day1-part1: ${day1.part1}")
  println(s"Answer day1-part2: ${day1.part2}")
}
