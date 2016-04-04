name := "Lift 2.6 Heroku starter template"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "https://oss.sonatype.org/content/repositories/releases"
)

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  val liftEdition = liftVersion.substring(0, 3)
  Seq(
    "net.liftweb"             %% "lift-webkit"                        % liftVersion           % "compile",
    "net.liftmodules"         %% ("lift-jquery-module_"+liftEdition)  % "2.9"                 % "compile",
    "org.eclipse.jetty"       %  "jetty-webapp"                       % "9.2.7.v20150116"     % "compile",
    "org.eclipse.jetty"       %  "jetty-plus"                         % "9.2.7.v20150116"     % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" %  "javax.servlet"                      % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"          %  "logback-classic"                    % "1.0.6",
    "org.specs2"              %% "specs2"                             % "2.3.12"              % "test"
  )
}

enablePlugins(JettyPlugin)

enablePlugins(JavaAppPackaging)

bashScriptConfigLocation := Some("${app_home}/../conf/jvmopts")

mainClass in Compile := Some("bootstrap.liftweb.Start")
