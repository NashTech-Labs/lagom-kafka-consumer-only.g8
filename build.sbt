// give the user a nice default project!
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.knoldus",
      scalaVersion := "2.11.8"
    )),
    name := "lagom-kafka-consumer-only"
  )
