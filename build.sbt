name := "sBCrypt"

organization := "net.connectedcaching"

version := "1.0"

scalaVersion := "2.9.2"

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

crossPaths := false

libraryDependencies ++= Seq(
	"org.mindrot" % "jbcrypt" % "0.3m",
	"org.specs2" %% "specs2" % "1.12" % "test"
)

initialCommands := "import net.connectedcaching.sbcrypt._"
