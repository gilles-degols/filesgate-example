package net.degols.example.fsgate.example.pipeline

import java.util.concurrent.{ExecutorService, Executors}

import akka.stream.scaladsl.Sink
import net.degols.example.fsgate.example.utils.UrlIterator
import net.degols.libs.filesgate.orm.{FileContent, FileMetadata}
import net.degols.libs.filesgate.pipeline.datasource.{DataSourceApi, DataSourceSeed}
import net.degols.libs.filesgate.pipeline.download.DownloadMessage
import net.degols.libs.filesgate.utils.Tools
import org.joda.time.DateTime
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.json.Json

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

class Source(implicit val tools: Tools) extends DataSourceApi{
  private val logger: Logger = LoggerFactory.getLogger(getClass)
  val threadPool: ExecutorService = Executors.newFixedThreadPool(20)
  implicit val executionContext: ExecutionContextExecutor =  ExecutionContext.fromExecutor(threadPool)

  override def process(sourceSeed: DataSourceSeed): Iterator[FileMetadata] = {
    new UrlIterator(1, 10000000)
  }
}