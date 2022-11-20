ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion :="2.13.10"
mainClass := Some("sampo.mundialito.Entrypoint")


lazy val root = (project in file("."))
  .settings(
    name := "MundialRandom"
  )
