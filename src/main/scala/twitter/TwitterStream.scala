package twitter

import twitter4j._

object StatusStreamer {
  def main(args: Array[String]) {
    println("hi")
  }

  object Util {
    val config = new twitter4j.conf.ConfigurationBuilder()
      .setOAuthConsumerKey("ZbE6epVuK2H1ZlUqltYBnCzyt")
      .setOAuthConsumerSecret("ZZTFWrhg9O3nnHLPGt1FifYFltnjdCbJs8BDS5X3SaGw2UgNWK")
      .build
  }

//  def simpleStatusListener = new StatusListener() {
//    def onStatus(status: Status) { println(status.getText) }
//    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
//    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
//    def onException(ex: Exception) { ex.printStackTrace }
//    def onScrubGeo(arg0: Long, arg1: Long) {}
//    def onStallWarning(warning: StallWarning) {}
//  }
}
