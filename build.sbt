name := "akka-viz-demo"

organization := "com.blstream.akkavizdemo"

scalaVersion := "2.11.7"

licenses +=("MIT", url("http://opensource.org/licenses/MIT"))

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.1",
  "io.spray" %% "spray-can" % "1.3.3",
  "io.spray" %% "spray-routing" % "1.3.3"
)

