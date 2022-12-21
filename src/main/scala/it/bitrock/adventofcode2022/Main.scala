package it.bitrock.adventofcode2022

object Main extends App {
  var allDays = List(new Day1, new Day2, new Day3, new Day4, new Day5)

  allDays.foreach(d => d.printResult())
}
