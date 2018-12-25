package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.matcher.{MatcherApi, MatcherMessage}

import scala.concurrent.{ExecutionContext, Future}

class Matcher(implicit val ec: ExecutionContext) extends MatcherApi{
  /**
    * @param fileMetadata
    * @return true if the current pipeline is meant to download the file, or not.
    */
  override def process(matcherMessage: MatcherMessage): Future[MatcherMessage] = {
    Future{matcherMessage}
  }
}
