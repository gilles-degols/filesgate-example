package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.matcher.{MatcherApi, MatcherMessage}

class Matcher extends MatcherApi{
  /**
    * @param fileMetadata
    * @return true if the current pipeline is meant to download the file, or not.
    */
  override def process(matcherMessage: MatcherMessage): MatcherMessage = {
    matcherMessage
  }
}
