name := "TwitterAnalysis"

version := "v0.1"

scalaVersion := "2.11.12"


lazy val sparkVersion = "2.4.5"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-hive" % sparkVersion,
"org.apache.spark" %% "spark-sql" % sparkVersion,
"org.apache.spark" %% "spark-yarn" % sparkVersion,
"org.apache.spark" %% "spark-streaming" % sparkVersion,
"org.apache.spark" %% "spark-streaming-twitter" % "1.6.3"
)
