package it.bitrock.adventofcode2022

import scala.io.Source

class Day1 {

  private def part1: Int = {
    doWorkPart1(extractListFromFile())
  }

  def doWorkPart1(inputList: List[String]) = {
    extractCaloriesSumList(inputList).max
  }
  private def part2: Int = {
    doWorkPart2(extractListFromFile())
  }

  def doWorkPart2(inputList: List[String]): Int = {
    extractCaloriesSumList(inputList)
      .sortWith(_ > _)
      .slice(0, 3)
      .sum
  }

  def extractListFromFile(): List[String] = {
    val inputFile = Source.fromResource(Day1.file)
    inputFile.mkString.trim
      .split("\n\n")
      .toList
  }

  def extractCaloriesSumList(inputList: List[String]): List[Int] = {
    inputList
      .map(
        _.split("\n")
          .map(_.toInt)
          .sum
      )
  }
}

object Day1 extends App {
  private val file = "input-day1.txt"

  val day1 = new Day1
  println(s"Answer day1-part1: ${day1.part1}")
  println(s"Answer day1-part2: ${day1.part2}")
}
