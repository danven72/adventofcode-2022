package it.bitrock.adventofcode2022;

import org.scalatest.funsuite.AnyFunSuite

class Day4Spec extends AnyFunSuite {
  val day4 = new Day4

  test("isOverlappingPart1") {
    assert(day4.isOverlappingPart1("2-4,6-8") == false)
    assert(day4.isOverlappingPart1("2-3,4-5") == false)
    assert(day4.isOverlappingPart1("5-6,7-9") == false)
    assert(day4.isOverlappingPart1("2-8,3-7") == true)
    assert(day4.isOverlappingPart1("6-6,4-6") == true)
    assert(day4.isOverlappingPart1("2-6,4-8") == false)
    assert(day4.isOverlappingPart1("36-78,21-65") == false)
  }

  test("isOverlappingPart2") {
    assert(day4.isOverlappingPart2("2-4,6-8") == false)
    assert(day4.isOverlappingPart2("2-3,4-5") == false)
    assert(day4.isOverlappingPart2("5-6,7-9") == false)
    assert(day4.isOverlappingPart2("2-8,3-7") == true)
    assert(day4.isOverlappingPart2("6-6,4-6") == true)
    assert(day4.isOverlappingPart2("2-6,4-8") == true)
    assert(day4.isOverlappingPart2("36-78,21-65") == true)
  }

  test("doWork part1") {
    val input = List(
      "2-4,6-8",
      "2-3,4-5",
      "5-6,7-9",
      "2-8,3-7",
      "6-6,4-6",
      "2-6,4-8",
      "36-78,21-65"
    )
    val result = day4.doWork(input, day4.isOverlappingPart1)
    assert(result == 2)
  }

  test("doWork part2") {
    val input = List(
      "2-4,6-8",
      "2-3,4-5",
      "5-6,7-9",
      "2-8,3-7",
      "6-6,4-6",
      "2-6,4-8",
      "36-78,21-65"
    )
    val result = day4.doWork(input, day4.isOverlappingPart2)
    assert(result == 4)
  }

}
