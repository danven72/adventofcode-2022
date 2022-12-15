package it.bitrock.adventofcode2022

import scala.io.Source

class Day4 {
  def part1: Int = {
    val inputFile = Source.fromResource(Day4.file)
    val input = inputFile.mkString
    input.trim
      .split("\n")
      .toList
      .map(sectionAssignment => isOverlapping(sectionAssignment))
      .filter(el => el == true)
      .size
  }

  def isOverlapping(sectionAssignment: String): Boolean = {
    val pairSection = sectionAssignment.split(",")
    val firstSection = pairSection(0).split("-")
    val secondSection = pairSection(1).split("-")
    val A = firstSection(0).toInt
    val B = firstSection(1).toInt
    val C = secondSection(0).toInt
    val D = secondSection(1).toInt
    val result =
      (
        (C >= A && D <= B) || (A >= C && B <= D)
      )
    //println(s"${sectionAssignment} -> overlapping: " + result)
    result
  }
}

object Day4 extends App {
  private val file = "input-day4.txt"
  val day4 = new Day4
  println(s"Answer day4-part1: ${day4.part1}")
  /*
  println(day4.isOverlapping("2-4,6-8"))
  println(day4.isOverlapping("2-3,4-5"))
  println(day4.isOverlapping("5-6,7-9"))
  println(day4.isOverlapping("2-8,3-7"))
  println(day4.isOverlapping("6-6,4-6"))
  println(day4.isOverlapping("2-6,4-8"))

  println(day4.isOverlapping("36-78,21-65"))

   */
}
