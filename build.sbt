ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "adventofcode-2022"
  )

val scalaTestVersion = "3.2.14"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test
)

//mainClass in (Compile, run) := Some("it.bitrock.adventofcode2022.Main")
