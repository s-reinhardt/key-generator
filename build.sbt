organization in ThisBuild := "org.weteam"

name := "id-generator"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

resolvers +=  Resolver.bintrayRepo("scalaz", "releases")

Publish.settings