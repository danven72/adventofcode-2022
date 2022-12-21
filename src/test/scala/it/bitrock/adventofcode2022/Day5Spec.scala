package it.bitrock.adventofcode2022

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.Stack

class Day5Spec extends AnyFunSuite {
  val day5 = new Day5

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
    println(newCrateStack.stacksStatusResult())
  }

  test("move") {
    val stacksLine = " 1   2   3 "
    val inputStateList =
      List(
        stacksLine,
        "[Z] [M] [P]",
        "[N] [C]    ",
        "    [D]    "
      )
    val crateStacks = day5.initCrateStacks(inputStateList)
    println("1->" + crateStacks.getCrateStackAt(1))
    println("2->" + crateStacks.getCrateStackAt(2))
    println("3->" + crateStacks.getCrateStackAt(3))

    val move = Move("move 1 from 2 to 1")
    val newCrateStacks: CrateStacks = crateStacks.applyMove(move)
    println("**********")
    println("1->" + newCrateStacks.getCrateStackAt(1))
    println("2->" + newCrateStacks.getCrateStackAt(2))
    println("3->" + newCrateStacks.getCrateStackAt(3))

    assert(newCrateStacks.getCrateStackAt(1) == Stack(Crate("[D]"), Crate("[N]"), Crate("[Z]")))
    assert(newCrateStacks.getCrateStackAt(2) == Stack(Crate("[C]"), Crate("[M]")))
    assert(newCrateStacks.getCrateStackAt(3) == Stack(Crate("[P]")))
  }

  test("applyMoveListPart1") {
    val stacksLine = " 1   2   3 "
    val inputStateList =
      List(
        stacksLine,
        "[Z] [M] [P]",
        "[N] [C]    ",
        "    [D]    "
      )
    val crateStacks = day5.initCrateStacks(inputStateList)
    val moves = List(Move(1, 2, 1), Move(3, 1, 3), Move(2, 2, 1), Move(1, 1, 2))
    val newCrateStacks = day5.applyMoveList(moves, crateStacks)
    //println("1->" + newCrateStacks.getCrateStackAt(1))
    //println("2->" + newCrateStacks.getCrateStackAt(2))
    //println("3->" + newCrateStacks.getCrateStackAt(3))
    println(newCrateStacks.stacksStatusResult())
    assert(newCrateStacks.getCrateStackAt(1) == Stack(Crate("[C]")))
    assert(newCrateStacks.getCrateStackAt(2) == Stack(Crate("[M]")))
    assert(newCrateStacks.getCrateStackAt(3) == Stack(Crate("[Z]"), Crate("[N]"), Crate("[D]"), Crate("[P]")))

  }
  test("applyMoveListPart2") {
    val stacksLine = " 1   2   3 "
    val inputStateList =
      List(
        stacksLine,
        "[Z] [M] [P]",
        "[N] [C]    ",
        "    [D]    "
      )
    val crateStacks = day5.initCrateStacks(inputStateList)
    //println("1->" + crateStacks.getCrateStackAt(1))
    //println("2->" + crateStacks.getCrateStackAt(2))
    //println("3->" + crateStacks.getCrateStackAt(3))
    val moves = List(Move(1, 2, 1), Move(3, 1, 3), Move(2, 2, 1), Move(1, 1, 2))
    val newCrateStacks = day5.applyMoveListPart2(moves, crateStacks)
    //println("1->" + newCrateStacks.getCrateStackAt(1))
    //println("2->" + newCrateStacks.getCrateStackAt(2))
    //println("3->" + newCrateStacks.getCrateStackAt(3))
    println(newCrateStacks.stacksStatusResult())
    assert(newCrateStacks.getCrateStackAt(1) == Stack(Crate("[M]")))
    assert(newCrateStacks.getCrateStackAt(2) == Stack(Crate("[C]")))
    assert(newCrateStacks.getCrateStackAt(3) == Stack(Crate("[D]"), Crate("[N]"), Crate("[Z]"), Crate("[P]")))


  }

}
