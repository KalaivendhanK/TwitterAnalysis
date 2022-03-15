name := "TwitterAnalysis"

version := "v0.1"

scalaVersion := "2.11.12"


lazy val sparkVersion = "2.4.5"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-hive" % sparkVersion,
"org.apache.spark" %% "spark-sql" % sparkVersion,
"org.apache.spark" %% "spark-yarn" % sparkVersion,
"org.apache.spark" %% "spark-streaming" % sparkVersion,

  /**
  The twitter 1.6.3 version looks for the dependency org.apache.spark.Logging wihch is only
  available with spark version 1.5.6 and lower. Since, we don't need to downgrade to the lower versions of spark.
  I have used the spark-streaming-twitter dependency from different org as mentioned below
  **/
  //"org.apache.spark" %% "spark-streaming-twitter" % "1.6.3"

  "org.apache.bahir" %% "spark-streaming-twitter" % "2.0.0"
)
