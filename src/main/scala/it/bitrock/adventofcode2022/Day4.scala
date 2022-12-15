package it.bitrock.adventofcode2022

import scala.io.Source

class Day4 {
  def part1: Int = {
    val inputFile = Source.fromResource(Day4.file)
    val input = inputFile.mkString
    input.trim
      .split("\n")
      .toList
      .map(sectionAssignment => isOverlapping(sectionAssignment))
      .filter(el => el == true)
      .size
  }

  def isOverlapping(sectionAssignment: String): Boolean = {
    val sectionProvider = new SectionProvider(sectionAssignment)
    sectionProvider.isThereSectionOverlap
  }

  class SectionProvider(sectionAssignment: String) {

    class Section(sectionExtremes: Array[String]) {
      def start: Int = sectionExtremes(0).toInt
      def end: Int = sectionExtremes(1).toInt

      override def toString: String = {
        s"start: $start - end: $end"
      }
    }

    object Section {
      def apply(value: String): Section = {
        val pairSection = value.split("-")
        new Section(pairSection)
      }
    }

    val pairSection = sectionAssignment.split(",")

    val firstSection = Section(pairSection(0))
    val secondSection = Section(pairSection(1))

    def isThereSectionOverlap: Boolean = {
      (
        (secondSection.start >= firstSection.start && secondSection.end <= firstSection.end)
        ||
        (firstSection.start >= secondSection.start && firstSection.end <= secondSection.end)
      )
    }
  }

}

object Day4 extends App {
  private val file = "input-day4.txt"
  val day4 = new Day4
  println(s"Answer day4-part1: ${day4.part1}")
  /*
  println(day4.isOverlapping("2-4,6-8"))
  println(day4.isOverlapping("2-3,4-5"))
  println(day4.isOverlapping("5-6,7-9"))
  println(day4.isOverlapping("2-8,3-7"))
  println(day4.isOverlapping("6-6,4-6"))
  println(day4.isOverlapping("2-6,4-8"))
  println(day4.isOverlapping("36-78,21-65"))

   */

}
