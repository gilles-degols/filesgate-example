package net.degols.example.fsgate.example.pipeline

import java.util.concurrent.{ExecutorService, Executors}

import net.degols.example.fsgate.example.utils.UrlIterator
import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.datasource.{DataSourceApi, DataSourceSeed}
import net.degols.libs.filesgate.utils.Tools
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

class SourceTwo(implicit val tools: Tools) extends DataSourceApi{
  private val logger: Logger = LoggerFactory.getLogger(getClass)
  val threadPool: ExecutorService = Executors.newFixedThreadPool(20)
  implicit val executionContext: ExecutionContextExecutor =  ExecutionContext.fromExecutor(threadPool)

  override def process(sourceSeed: DataSourceSeed): Iterator[FileMetadata] = {
    new UrlIterator(10000001, 10000100)
  }
}
