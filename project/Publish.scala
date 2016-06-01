import sbt._, Keys._
import bintray.BintrayKeys._


object Publish {

  val bintraySettings = Seq(
    bintrayOrganization := Some("reini"),
    bintrayPackageLabels := Seq("readable id generator", "id generator")
  )

  val publishingSettings = Seq(
    publishMavenStyle := true,
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("https://github.com/s-reinhardt/id-generator")),
    scmInfo := Some(ScmInfo(url("https://github.com/s-reinhardt/id-generator"),
      "git@github.com:s-reinhardt/id-generator.git")),
    pomIncludeRepository := { _ => false },
    publishArtifact in Test := false
  )

  val settings = bintraySettings ++ publishingSettings
}