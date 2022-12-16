package it.bitrock.adventofcode2022

class Day4(order: Int = 4) extends AbstractDay(order) {

  def doWork(
      inputList: List[String],
      overlapFunction: String => Boolean
  ): Int = {
    inputList
      .map(sectionAssignment => overlapFunction(sectionAssignment))
      .filter(el => el == true)
      .size
  }

  override protected def part1: Int = {
    doWork(extractListFromFile(file), isOverlappingPart1)
  }

  override protected def part2: Int = {
    doWork(extractListFromFile(file), isOverlappingPart2)
  }

  def isOverlappingPart1(sectionAssignment: String): Boolean = {
    val sectionProvider = new SectionProvider(sectionAssignment)
    sectionProvider.isThereSectionOverlap
  }

  def isOverlappingPart2(sectionAssignment: String): Boolean = {
    val sectionProvider = new SectionProvider(sectionAssignment)
    !sectionProvider.noIntersection
  }

  // TODO: This class should be extracted and tested
  private class SectionProvider(sectionAssignment: String) {
    class Section(sectionExtremes: Array[String]) {
      def begin: Int = sectionExtremes(0).toInt
      def end: Int = sectionExtremes(1).toInt

      override def toString: String = {
        s"start: $begin - end: $end"
      }
    }
    object Section {
      def apply(value: String): Section = {
        new Section(value.split("-"))
      }
    }

    private val pairSection = sectionAssignment.split(",")
    val firstSection = Section(pairSection(0))
    val secondSection = Section(pairSection(1))

    def isThereSectionOverlap: Boolean = {
      (
        (secondSection.begin >= firstSection.begin && secondSection.end <= firstSection.end)
        ||
        (firstSection.begin >= secondSection.begin && firstSection.end <= secondSection.end)
      )
    }

    def noIntersection: Boolean = {
      (
        (secondSection.begin > firstSection.end && secondSection.end > firstSection.end)
        ||
        (firstSection.begin > secondSection.end && firstSection.end > secondSection.end)
      )
    }
  }
}

object Day4 extends App {
  val day4 = new Day4
  day4.printResult()
}
