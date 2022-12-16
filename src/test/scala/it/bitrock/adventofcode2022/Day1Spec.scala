package it.bitrock.adventofcode2022

import org.scalatest.funsuite.AnyFunSuite

class Day1Spec extends AnyFunSuite {

  val day1 = new Day1
  val inputList =
    List("1000\n2000\n3000", "4000", "5000\n6000", "7000\n8000\n9000", "1000")

  test("extractCaloriesSumList") {
    //println(inputList)
    val caloriesSumList = day1.extractCaloriesSumList(inputList)
    //println(caloriesSumList)
    equals(caloriesSumList == List(6000, 4000, 11000, 24000, 1000))
  }

  test("doWorkPart1") {
    equals(day1.doWorkPart1(inputList), 24000)
  }

  test("doWorkPart2") {
    equals(day1.doWorkPart1(inputList), 45000)
  }
}
