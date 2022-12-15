package it.bitrock.adventofcode2022

import org.scalatest.funsuite.AnyFunSuite

class Day2Spec extends AnyFunSuite {
  val day2 = new Day2

  test("getPointsPart1") {
    assert(day2.getPointsPart1("A X") == 4)
    assert(day2.getPointsPart1("A Y") == 8)
    assert(day2.getPointsPart1("A Z") == 3)
    assert(day2.getPointsPart1("B X") == 1)
    assert(day2.getPointsPart1("B Y") == 5)
    assert(day2.getPointsPart1("B Z") == 9)
    assert(day2.getPointsPart1("C X") == 7)
    assert(day2.getPointsPart1("C Y") == 2)
    assert(day2.getPointsPart1("C Z") == 6)

    assert(day2.getPointsPart1("W Q") == 0)
  }

  test("getPointsPart2") {
    assert(day2.getPointsPart2("A X") == 3)
    assert(day2.getPointsPart2("A Y") == 4)
    assert(day2.getPointsPart2("A Z") == 8)
    assert(day2.getPointsPart2("B X") == 1)
    assert(day2.getPointsPart2("B Y") == 5)
    assert(day2.getPointsPart2("B Z") == 9)
    assert(day2.getPointsPart2("C X") == 2)
    assert(day2.getPointsPart2("C Y") == 6)
    assert(day2.getPointsPart2("C Z") == 7)

    assert(day2.getPointsPart1("W Q") == 0)
  }

  test("doWork part1") {
    val inputList = List("A Y", "B X", "C Z")
    assert(day2.doWork(inputList, day2.getPointsPart1) == 15)
  }

  test("doWork part2") {
    val inputList = List("A Y", "B X", "C Z")
    assert(day2.doWork(inputList, day2.getPointsPart2) == 12)
  }

}
