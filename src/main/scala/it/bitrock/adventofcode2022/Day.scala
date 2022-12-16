package it.bitrock.adventofcode2022

trait Day {

  protected def part1: Any
  protected def part2: Any
}

abstract class AbstractDay(order: Int) extends Day {
  protected val file = s"input-day${order}.txt"

  def printResult(): Unit = {
    println(s"Answer day${order}-part1: ${part1}")
    println(s"Answer day${order}-part2: ${part2}")
    println()
  }

}
