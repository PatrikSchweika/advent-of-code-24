ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.5.2"

lazy val root = (project in file("."))
  .settings(
    name := "AdventOfCode24",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )

