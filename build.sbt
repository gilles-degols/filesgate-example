import play.sbt.PlayScala
import sbt.RootProject

name := "fsgate-example"
 
version := "0.0.1"

scriptClasspath in bashScriptDefines ~= (cp => "/../../../../../../../../../../etc/net.degols/local:/../../../../../../../../../../usr/lib/net.degols/election/conf/application.conf" +: cp)

scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps")

lazy val `filesgate` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"
lazy val playVersion = "2.6.1"
lazy val akkaVersion = "2.5.2"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

// Filesgate library
val filesgateLibraryVersion = "0.0.1"
val filesgatePath = "../filesgate"
lazy val filesgateLibrary: RootProject = RootProject(file(filesgatePath))
val useLocalFilesgateLibrary = true
val localFilesgateAvailable = scala.reflect.io.File(scala.reflect.io.Path(filesgatePath)).exists
lazy val proj = if(localFilesgateAvailable && useLocalFilesgateLibrary) {
  (project in file(".")).enablePlugins(PlayScala).dependsOn(filesgateLibrary)
} else {
  (project in file(".")).enablePlugins(PlayScala)
}

lazy val filesgateDependency = if(localFilesgateAvailable && useLocalFilesgateLibrary) {
  Seq()
} else {
  Seq("net.degols" %% "filesgate" % filesgateLibraryVersion exclude("log4j", "log4j") exclude("org.slf4j","slf4j-log4j12"))
}
libraryDependencies ++= filesgateDependency

// Akka Remoting
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % akkaVersion

