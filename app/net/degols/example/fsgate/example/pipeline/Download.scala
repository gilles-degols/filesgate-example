package net.degols.example.fsgate.example.pipeline

import net.degols.libs.cluster.Tools
import net.degols.libs.filesgate.orm.RawFileContent
import net.degols.libs.filesgate.pipeline.download.{DownloadApi, DownloadMessage}
import net.degols.libs.filesgate.pipeline.prestorage.PreStorageMessage
import net.degols.libs.filesgate.utils.Tools
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.json.Json

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

class Download(implicit val ec: ExecutionContext, tools: Tools) extends DownloadApi{
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  /**
    * @param downloadMessage
    * @return
    */
  override def process(downloadMessage: DownloadMessage): Future[DownloadMessage] = {
    logger.info(s"Should download ${downloadMessage.fileMetadata.url}. Time is ${Tools.datetime()}")

    tools.downloadFileInMemory(downloadMessage.fileMetadata.url).map(rawDownloadFile => {
      val duration = rawDownloadFile.end.getTime - rawDownloadFile.start.getTime
      val content = new RawFileContent()
      val downloadMetadata = Json.obj(
        "download_start" -> Json.obj("$date" -> rawDownloadFile.start.getTime),
        "download_duration_ms" -> duration,
        "size_b" -> rawDownloadFile.size
      )
      DownloadMessage(downloadMessage.fileMetadata, downloadMessage.abort, Option(content), Option(downloadMetadata))
    })
  }
}
