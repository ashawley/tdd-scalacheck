scalaVersion  := "2.11.11"

name := "tdd-scalacheck"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)
