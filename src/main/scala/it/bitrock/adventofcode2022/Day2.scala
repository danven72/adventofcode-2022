package it.bitrock.adventofcode2022

import scala.io.Source

class Day2 {

  def doWork(inputList: List[String], f: String => Int): Int = {
    inputList.map(s => f(s)).sum
  }

  private def part1: Int = {
    doWork(extractListFromFile(Day2.file), getPointsPart1)
  }

  private def part2: Int = {
    doWork(extractListFromFile(Day2.file), getPointsPart2)
  }

  // public for test
  def getPointsPart1(inputLine: String): Int = {
    // win=6P, draw=3P, 0P=lost
    // A - X (1P) Rock
    // B - Y (2P) Paper
    // C - Z (3P) Scissor
    inputLine match {
      case "A X" => 4 // draw
      case "A Y" => 8 // win
      case "A Z" => 3 // lost
      case "B X" => 1 // lost
      case "B Y" => 5 // draw
      case "B Z" => 9 // win
      case "C X" => 7 // win
      case "C Y" => 2 // lost
      case "C Z" => 6 // draw
      case _ =>
        println(s"ERROR: $inputLine not recognized!!!")
        0
    }
  }

  // public for test
  def getPointsPart2(inputLine: String): Int = {
    // win=6P, draw=3P, 0P=lost
    // A  Rock    1P  X must loose
    // B  Paper   2P  Y must draw
    // C  Scissor 3P  Z must win
    inputLine match {
      case "A X" => 3 // loose playing scissor
      case "A Y" => 4 // draw playing rock
      case "A Z" => 8 // win playing paper
      case "B X" => 1 // loose playing rock
      case "B Y" => 5 // draw playing paper
      case "B Z" => 9 // win playing scissor
      case "C X" => 2 // loose playing paper
      case "C Y" => 6 // draw playing scissor
      case "C Z" => 7 // win playing rock
      case _ =>
        println(s"ERROR: $inputLine not recognized!!!")
        0
    }
  }

}

object Day2 extends App {
  val file = "input-day2.txt"
  val day2 = new Day2
  println(s"Answer day2-part1: ${day2.part1}")
  println(s"Answer day2-part2: ${day2.part2}")
}
