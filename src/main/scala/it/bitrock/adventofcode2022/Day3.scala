package it.bitrock.adventofcode2022

import scala.annotation.tailrec

class Day3(order: Int = 3) extends AbstractDay(order) {
  override protected def part1: Int = {
    doWorkPart1(extractListFromFile(file))
  }

  def doWorkPart1(inputList: List[String]): Int = {
    inputList
      .map(s => findItem(s))
      .map(i => calculatePriority(i))
      .sum
  }

  override protected def part2: Int = {
    doWorkPart2(extractListFromFile(file))
  }

  def doWorkPart2(inputList: List[String]): Int = {
    inputList
      .grouped(3)
      .toList
      .map(inputGroup => findBadge(inputGroup))
      .map(item => calculatePriority(item))
      .sum
  }
  // public for test
  def findItem(inputLine: String): Char = {
    @tailrec
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

  private def calculatePriority(item: Char): Int = {
    if (item.isUpper)
      item.toInt - 38
    else
      item.toInt - 96
  }

  // public for Test
  def findBadge(inputGroup: List[String]): Char = {
    @tailrec
    def doFind(first: String, second: String, third: String): Char = {
      if (second.contains(first.head) && third.contains(first.head))
        first.head
      else
        doFind(first.tail, second, third)
    }

    doFind(inputGroup(0), inputGroup(1), inputGroup(2))
  }
}

object Day3 extends App {
  val day3 = new Day3
  day3.printResult()
}
