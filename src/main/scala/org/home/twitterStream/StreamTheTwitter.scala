package org.home.twitterStream

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.DataStreamReader
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import twitter4j.Status
import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.{Configuration, ConfigurationBuilder}

object StreamTheTwitter extends App {

//  val spark: SparkSession = SparkSession.builder().master("local").getOrCreate()
//  Logger.getLogger("org").setLevel(Level.ERROR)

  val ssc: StreamingContext                      = new StreamingContext("local[2]", "TweetStream", Seconds(20))
  val configurationBuilder: ConfigurationBuilder = new ConfigurationBuilder()

  val builder: Configuration = configurationBuilder
    .setDebugEnabled(true)
    .setOAuthConsumerKey("***********")
    .setOAuthConsumerSecret("*************")
    .setOAuthAccessToken("*****************")
    .setOAuthAccessTokenSecret("******************")
    .build()

  val authentication: OAuthAuthorization          = new OAuthAuthorization(builder)
  val twitterStream: ReceiverInputDStream[Status] =
    TwitterUtils.createStream(ssc, Some(authentication))

  val lines = twitterStream.map(_.getText)
  lines.print()

  ssc.start()
  ssc.awaitTermination()

}
