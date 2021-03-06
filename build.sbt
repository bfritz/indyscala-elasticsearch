name := "elasticsearch-from-scala"

organization := "com.bfritz.example"

version := "0.1.0-SNAPSHOT"

homepage := Some(url("https://github.com/bfritz/elasticsearch-from-scala"))

startYear := Some(2013)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/bfritz/elasticsearch-from-scala"),
    "scm:git:https://github.com/bfritz/elasticsearch-from-scala.git",
    Some("scm:git:git@github.com:bfritz/elasticsearch-from-scala.git")
  )
)

/* scala versions and options */
scalaVersion := "2.10.2"

crossScalaVersions := Seq(
/*  "2.9.3-RC1",
  "2.9.2",
  "2.9.1", "2.9.1-1",
  "2.9.0", "2.9.0-1",
  "2.8.0", "2.8.1", "2.8.2" */
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  ,"-unchecked"
  ,"-encoding", "UTF-8"
  ,"-target:jvm-1.6"
  ,"-Xlint"
  // "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.10") List(
    "-Xverify"
    ,"-Ywarn-all"
    ,"-feature"
    ,"-language:postfixOps"
    // "-language:reflectiveCalls",
    ,"-language:implicitConversions"
    // "-language:higherKinds",
    // "-language:existentials",
    // "-language:experimental.macros",
    // "-language:experimental.dynamics"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq (
  "com.github.nscala-time" %% "nscala-time" % "0.6.0"
  // -- configuration --
  , "com.typesafe" % "config" % "1.0.2"
  // -- network --
  //,"net.databinder.dispatch" %% "dispatch-core" % "0.10.1"
  // -- testing --
  , "org.scalatest" % "scalatest_2.10" % "2.0.M6-SNAP36" % "test"
  , "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"
  // -- Logging --
  , "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"
  , "ch.qos.logback" % "logback-classic" % "1.0.13"
  // -- Akka --
  //,"com.typesafe.akka" %% "akka-testkit" % "2.2.1" % "test"
  //,"com.typesafe.akka" %% "akka-actor" % "2.2.1"
  //,"com.typesafe.akka" %% "akka-slf4j" % "2.2.1"
  // -- ElasticSearch --
  , "com.sksamuel.elastic4s" %% "elastic4s" % "0.90.5.2"
  // -- Sql --
  //,"com.typesafe.slick" %% "slick" % "1.0.1"
  // -- Spray --
  //,"io.spray" % "spray-routing" % "1.2-20130801"
  //,"io.spray" % "spray-client" % "1.2-20130801"
  //,"io.spray" % "spray-testkit" % "1.2-20130801" % "test"
  // -- json --
  //,"org.json4s" %% "json4s-native" % "3.2.5"
  // -- image processing --
  , "com.drewnoakes" % "metadata-extractor" % "2.6.2"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeRepo("releases")
  //"spray repo" at "http://nightlies.spray.io"
)

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("com.bfritz.example.ElasticSearch_From_Scala.Main")

assemblySettings

test in AssemblyKeys.assembly := {}

atmosSettings
