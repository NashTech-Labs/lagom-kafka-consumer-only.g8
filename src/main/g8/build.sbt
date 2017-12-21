organization in ThisBuild := "com.knoldus"

version in ThisBuild := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

lagomKafkaEnabled in ThisBuild := false

lazy val `helloservice` = (project in file("."))
  .aggregate(`helloservice-api`, `helloservice-impl`, `kafka-connect`)

lazy val `helloservice-api` = (project in file("helloservice-api"))
  .settings(common: _*)
  .settings(
    libraryDependencies ++= Seq(lagomJavadslApi, lagomJavadslKafkaClient)
  )

lazy val `kafka-connect` = (project in file("kafka-connect"))
  .settings(common: _*)
  .settings(
    libraryDependencies += lagomJavadslApi
  )

lazy val `helloservice-impl` = (project in file("helloservice-impl"))
  .enablePlugins(LagomJava)
  .settings(common: _*)
  .dependsOn(`helloservice-api`, `kafka-connect`)

def common = Seq(
  javacOptions in compile += "-parameters"
)

