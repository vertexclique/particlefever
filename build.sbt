name := "particlefever"

version := "1.0"

scalaVersion := "2.12.2"


libraryDependencies ++= {
  val akkaV = "2.5.3"
  val scalaTestV  = "3.0.1"
  val scalaMockV = "3.6.0"

  Seq(
    "com.typesafe.akka"         %% "akka-actor"                   % akkaV,
    "org.scala-lang.modules"    %% "scala-swing"                  % "2.0.0",
    "com.lihaoyi" %% "fastparse" % "0.4.3",
    "org.scala-lang.modules"    %% "scala-parser-combinators"     % "1.0.6",
    "com.lihaoyi"               %% "fansi"                        % "0.2.4",

  // Test libraries
    "org.scalatest"          %% "scalatest"                    % scalaTestV % Test,
    "org.scalamock"          %% "scalamock-scalatest-support"  % scalaMockV % Test,
    "org.scalamock"          %% "scalamock-core"               % scalaMockV % Test,
    "com.github.tomakehurst" %  "wiremock-standalone"          % "2.6.0"    % Test,
    "com.typesafe.akka"      %% "akka-testkit"                 % akkaV      % Test
  )
}
