name := "scalatest-util"

version := "0.1"

organization := "org.waman.scalatest_util"

scalaVersion := "2.11.7"


//***** Custom settings *****
val javaVersion = settingKey[String]("javac source/target version")

val encoding = settingKey[String]("source encoding")

javaVersion := "1.8"

encoding := "UTF-8"

// ***** Dependencies *****
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalamock" % "scalamock-scalatest-support_2.11" % "3.2.2" % "test"
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
