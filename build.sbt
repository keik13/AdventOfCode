Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.1"
ThisBuild / scalafmtOnCompile := true

lazy val y2023 = (project in file("2023"))
  .settings(
    name := "2023",
  )

lazy val root = project
  .in(file("."))
  .aggregate(y2023)