package net.degols.example.fsgate.example.pipeline

import java.util.concurrent.{Executors, ScheduledExecutorService}

import akka.actor.ActorContext
import net.degols.libs.filesgate.pipeline.AbortStep
import net.degols.libs.filesgate.pipeline.matcher.{MatcherApi, MatcherMessage}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

class MatcherTwo(implicit val ec: ExecutionContext, context: ActorContext) extends MatcherApi{

  val r = Random

  override def process(matcherMessage: MatcherMessage): Future[MatcherMessage] = {
    Future{
      if(r.nextInt(10) == 0) {
        val abort = AbortStep("Any reason", Option(0L))
        MatcherMessage(matcherMessage.fileMetadata, Option(abort))
      } else {
        matcherMessage
      }
    }
  }
}

