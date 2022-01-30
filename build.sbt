name := "Sparksql_utils"

version := "v0.1"

scalaVersion := "2.12.13"


lazy val sparkVersion = "3.0.2"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-hive" % sparkVersion,
"org.apache.spark" %% "spark-sql" % sparkVersion,
"org.apache.spark" %% "spark-yarn" % sparkVersion,
"org.apache.spark" %% "spark-streaming" % sparkVersion,
)
