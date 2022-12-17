package it.bitrock.adventofcode2022

import org.scalatest.funsuite.AnyFunSuite
import scala.collection.mutable.Stack

class Day5Spec extends AnyFunSuite {
  val day5 = Day5

  test("parseMove") {
    val moveInputStr = "move 5 from 3 to 6"
    val move = Move(moveInputStr)
    println(move)
    assert(move.cratesAmount == 5)
    assert(move.stackFrom == 3)
    assert(move.stackTo == 6)
  }

  test("CrateStacks") {
    val input = " 1   2   3   4   5   6   7   8   9 "
    val crateStacks = CrateStacks(input)
    println(crateStacks.getKeyList)
    //assert(move.cratesAmount == 5)
    //assert(move.stackFrom == 3)
    //assert(move.stackTo == 6)
  }

  test("initCratesStack") {
    val inputStr2 = "[M]                     [N] [Z]    "
    val inputStr1 = "[B] [N] [J] [S] [Z] [W] [F] [W] [R]"
    val input = " 1   2   3   4   5   6   7   8   9 "
    val crateStacks = CrateStacks(input)
    crateStacks.parseLine(inputStr1)
    val newCrateStack = crateStacks.parseLine(inputStr2)
    //println("****** " + newCrateStack)

    assert(
      newCrateStack.getCrateStackAt(1) == Stack(Crate("[M]"), Crate("[B]"))
    )
    assert(newCrateStack.getCrateStackAt(2) == Stack(Crate("[N]")))
    assert(newCrateStack.getCrateStackAt(3) == Stack(Crate("[J]")))
    assert(newCrateStack.getCrateStackAt(4) == Stack(Crate("[S]")))
    assert(newCrateStack.getCrateStackAt(5) == Stack(Crate("[Z]")))
    assert(newCrateStack.getCrateStackAt(6) == Stack(Crate("[W]")))
    assert(
      newCrateStack.getCrateStackAt(7) == Stack(Crate("[N]"), Crate("[F]"))
    )
    assert(
      newCrateStack.getCrateStackAt(8) == Stack(Crate("[Z]"), Crate("[W]"))
    )
    assert(newCrateStack.getCrateStackAt(9) == Stack(Crate("[R]")))
  }

  test("popLastLine") {
    val input = " 1   2   3   4   5   6   7   8   9 "
    val crateStacks = CrateStacks(input)
    //val inputStr1 = "[B] [N] [J] [S] [Z] [W] [F] [W] [R]"
    val inputStr2 = "[M]                     [N] [Z]    "
    //crateStacks.parseLine(inputStr1)
    val newCrateStack = crateStacks.parseLine(inputStr2)
    println(newCrateStack.popLastLine())
  }
}
