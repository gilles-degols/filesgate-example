package net.degols.example.fsgate.example.pipeline

import java.util.concurrent.{Callable, Executors, ScheduledExecutorService, TimeUnit}

import akka.actor.{ActorContext, ActorSystem}
import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.matcher.{MatcherApi, MatcherMessage}

import scala.concurrent.{ExecutionContext, Future}
import akka.pattern.after
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.duration._
class Matcher(implicit val ec: ExecutionContext, context: ActorContext) extends MatcherApi{
  // Useful if we want to stop downloading files during a specific time without using any Await
  val schedule: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
  private val logger = LoggerFactory.getLogger(getClass)

  /**
    * @param fileMetadata
    * @return true if the current pipeline is meant to download the file, or not.
    */
  override def process(matcherMessage: MatcherMessage): Future[MatcherMessage] = {
    // Code below to wait a specific time before downloading the message. This will automatically "stuck" the current pipeline
    //after(1 seconds, context.system.scheduler)(Future{matcherMessage})

    Future{matcherMessage}
  }
}
