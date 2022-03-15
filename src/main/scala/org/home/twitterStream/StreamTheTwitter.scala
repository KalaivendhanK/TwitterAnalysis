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
    .setOAuthConsumerKey("nv4adUnXinRi5aX6nSQ7oses8")
    .setOAuthConsumerSecret("DVaPlqQwYTUi1ohVy6fAYjSFC6KzBqYiKLgyqmkqBwYTiZxIOU")
    .setOAuthAccessToken("3969278838-PTKx6OZe4DpuSVbrgW6aGXixIbJ4EIIQq6nk9sm")
    .setOAuthAccessTokenSecret("7GDA4kesjMyMN6RjwMsufAwsMNp1zmGEKOsJQ1S6TVCb9")
    .build()

  val authentication: OAuthAuthorization          = new OAuthAuthorization(builder)
  val twitterStream: ReceiverInputDStream[Status] =
    TwitterUtils.createStream(ssc, Some(authentication))

  val lines = twitterStream.map(_.getText)
  lines.print()

  ssc.start()
  ssc.awaitTermination()

//  val spark = SparkSession.builder().master("local[2]").getOrCreate()
//  val stream: DataStreamReader = spark.readStream.format("twitter")
//    .option("twitter4j.oauth.consumerKey","nv4adUnXinRi5aX6nSQ7oses8")
//    .option("twitter4j.oauth.consumerSecret","DVaPlqQwYTUi1ohVy6fAYjSFC6KzBqYiKLgyqmkqBwYTiZxIOU")
//    .option("twitter4j.oauth.accessToken","3969278838-PTKx6OZe4DpuSVbrgW6aGXixIbJ4EIIQq6nk9sm")
//    .option("twitter4j.oauth.accessTokenSecret","7GDA4kesjMyMN6RjwMsufAwsMNp1zmGEKOsJQ1S6TVCb9")
//
//  stream.load()

}
