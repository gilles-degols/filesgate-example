package net.degols.example.fsgate.example.pipeline

import java.util.concurrent.{ExecutorService, Executors}

import akka.stream.scaladsl.Sink
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

  class urlIterator(start: Long, max: Long) extends Iterator[FileMetadata] {
    var i: Long = start

    override def hasNext: Boolean = i < max

    override def next(): FileMetadata = {
      i += 1
      if (i == 5 && false) {
        // Invalid url for test
        FileMetadata(s"http://127.0.0.1:8000/img/image-$i.jpg")
      } else {
        FileMetadata(s"http://127.0.0.1:8000/img/image.jpg?n=$i")
        //FileMetadata(s"http://127.0.0.1/img/stuff.txt?n=$i")
      }
    }
  }


  override def process(sourceSeed: DataSourceSeed): Iterator[FileMetadata] = {

    new urlIterator(1, 10000000)
  }
}