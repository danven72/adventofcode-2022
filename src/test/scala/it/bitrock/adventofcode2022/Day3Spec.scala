package it.bitrock.adventofcode2022

import org.scalatest.funsuite.AnyFunSuite

class Day3Spec extends AnyFunSuite {
  val day3 = new Day3
  val inputListForTest = List(
    "vJrwpWtwJgWrhcsFMMfFFhFp",
    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
    "PmmdzqPrVvPwwTWBwg",
    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
    "ttgJtRGJQctTZtZT",
    "CrZsJsPPZsGzwwsLwLmpwMDw"
  )

  test("findItem") {
    assert(day3.findItem("vJrwpWtwJgWrhcsFMMfFFhFp") == 'p')
    assert(day3.findItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL") == 'L')
    assert(day3.findItem("PmmdzqPrVvPwwTWBwg") == 'P')
    assert(day3.findItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn") == 'v')
    assert(day3.findItem("ttgJtRGJQctTZtZT") == 't')
    assert(day3.findItem("CrZsJsPPZsGzwwsLwLmpwMDw") == 's')
  }

  test("doWorkPart1") {
    assert(day3.doWorkPart1(inputListForTest) == 157)
  }

  test("findBadge") {
    assert(day3.findBadge(inputListForTest.slice(0, 3)) == 'r')
    assert(
      day3.findBadge(inputListForTest.slice(3, inputListForTest.size)) == 'Z'
    )
  }

  test("doWorkPart2") {
    assert(day3.doWorkPart2(inputListForTest) == 70)
  }

}
