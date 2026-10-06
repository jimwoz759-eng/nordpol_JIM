// BaseProject (com.fidesmo:base-project) was a private Fidesmo SBT plugin
// whose resolver is defunct. Replaced here with minimal inline settings.
// bintray publish settings also removed (Bintray closed 2021).

// Scala version matches original project era (SBT 0.13 + android-sdk-plugin 1.5.x)
val baseSettings = Seq(
  organization         := "com.fidesmo",
  scalaVersion         := "2.11.12",
  scalacOptions       ++= Seq("-deprecation", "-unchecked", "-feature"),
  licenses             += ("MIT", url("http://opensource.org/licenses/MIT")),
  publishArtifact      := false,
  publish              := {}
)

lazy val base = project.in(file("."))
  .settings(publish := {})
  .aggregate(core, android)

lazy val core = project
  .settings(
    (libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test")
      ++ baseSettings
  )

lazy val android = project
  .settings(baseSettings)
  .dependsOn(core)
