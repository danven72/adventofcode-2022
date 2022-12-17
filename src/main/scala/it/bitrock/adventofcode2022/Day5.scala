package it.bitrock.adventofcode2022

import scala.collection.mutable
import scala.io.Source
import scala.collection.mutable.Stack

class Day5(order: Int = 5) extends AbstractDay(order) {
  override protected def part1: Any = ???

  override protected def part2: Any = ???

  def doWorkPart1() = {
    def doInitCrateStacks(
        initStatusList: List[String],
        crateStack: CrateStacks
    ): CrateStacks = {
      initStatusList match {
        case line :: tail =>
          val newCrateStacks = crateStack.parseLine(line)
          doInitCrateStacks(tail, newCrateStacks)
        case Nil => crateStack
      }
    }

    val inputParseResult = parseFileInput
    val initStatusList = inputParseResult._1
    val initCrateStacks = CrateStacks(initStatusList(0))
    val loadedCrateStacks =
      doInitCrateStacks(initStatusList.tail, initCrateStacks)
    //println(loadedCrateStacks)
    println(loadedCrateStacks.popLastLine())
  }

  def parseFileInput: (List[String], List[Move]) = {
    val inputFile = Source.fromResource(file)
    val inputFileList = inputFile.mkString.trim
      .split("\n\n")
      .toList

    val beginPositionList = inputFileList
      .take(1)
      .flatMap(s => s.split("\n"))
      .reverse

    val movesList =
      inputFileList
        .slice(1, inputFileList.size)
        .flatMap(s => s.split("\n").toList)
        .map(m => Move(m))

    (beginPositionList, movesList)
  }
}

case class Move(cratesAmount: Int, stackFrom: Int, stackTo: Int) {}

object Move {
  def apply(inputLine: String): Move = {
    val numberInMovesList = inputLine.split("\\D+").filter(_.nonEmpty).toList
    Move(
      numberInMovesList(0).toInt,
      numberInMovesList(1).toInt,
      numberInMovesList(2).toInt
    )
  }
}

case class Crate(label: String) {
  def isEmpty(): Boolean = label.trim.isEmpty

}

case class CrateStacks(status: Map[Int, Stack[Crate]]) {
  def getCrateStackAt(i: Int) = {
    status.get(i).get
  }

  def popLastLine(): String = {
    val keyList = getKeyList
    val crateStacksSb = new StringBuilder()
    val labelStacksSb = new StringBuilder
    for (i <- 1 to keyList.size) {
      labelStacksSb.append(" ").append(i).append(" ")
      val stack = getCrateStackAt(i)
      if (!stack.isEmpty) {
        val crate = stack.pop()
        crateStacksSb.append(crate.label)
      } else
        crateStacksSb.append("   ")
    }
    crateStacksSb.append("\n").append(labelStacksSb.toString()).toString
  }

  def parseLine(input: String): CrateStacks = {
    def doParse(
        crateLineList: List[String],
        cratesLine: String
    ): List[String] = {
      if (cratesLine.length > 3) {
        val newList = crateLineList :+ cratesLine.substring(0, 3)
        val newInputStr = cratesLine.substring(4)
        doParse(newList, newInputStr)
      } else crateLineList :+ cratesLine
    }

    val crateLineList = doParse(List(), input)
    for (i <- 0 to crateLineList.size - 1) {
      val crate = Crate(crateLineList(i))
      if (!crate.isEmpty()) {
        val stack = status.get(i + 1).get
        stack.push(crate)
      }
    }
    CrateStacks(status)
  }

  def getKeyList: List[Int] =
    status.keys.toList.sorted

}
object CrateStacks {
  def apply(inputListCrateStr: String): CrateStacks = {
    val createsNumList = inputListCrateStr
      .split("\\D+")
      .toList
      .filter(_.nonEmpty)
      .map(s => s.toInt)
    val status = buildEmptyStacksInStatus(createsNumList, Map())

    CrateStacks(status)
  }

  private def buildEmptyStacksInStatus(
      createsNumList: List[Int],
      status: Map[Int, Stack[Crate]]
  ): Map[Int, Stack[Crate]] = {
    createsNumList match {
      case el :: tail =>
        val newStatus = status + (el -> Stack[Crate]())
        buildEmptyStacksInStatus(tail, newStatus)
      case Nil => status
    }
  }
}

object Day5 extends App {
  val day5 = new Day5
  day5.doWorkPart1()

  //println(s"initPositions: ${day5.parseFileInput._1}")
  /*
  val initStatusList = day5.parseFileInput._1
  val crateStacks = CrateStacks(initStatusList(0))
  crateStacks.parseLine(initStatusList(1))
  crateStacks.parseLine(initStatusList(2))
  crateStacks.parseLine(initStatusList(3))
  val last = crateStacks.parseLine(initStatusList(4))
  println(last)

   */
  //println(s"moves: ${day5.parseFileInput._2}")
}
