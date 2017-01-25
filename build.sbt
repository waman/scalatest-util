name := "scalatest-util"

version := "0.8"

organization := "org.waman"

scalaVersion := "2.12.1"


//***** Custom settings *****
val javaVersion = settingKey[String]("javac source/target version")

val encoding = settingKey[String]("source encoding")

javaVersion := "1.8"

encoding := "UTF-8"

// ***** Dependencies *****
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.1",
  "org.scalacheck" % "scalacheck_2.12" % "1.13.4"//,
  //"org.scala-lang.modules" % "scala-xml_2.12" % "1.0.4"
)

//***** Options *****
javacOptions ++= Seq(
  "-source", javaVersion.value,
  "-target", javaVersion.value,
  "-encoding", encoding.value
)

scalacOptions ++= Seq(
  "-Xlint",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-encoding", encoding.value
)

//***** Others *****
fork := true

crossPaths := false
