package net.degols.example.fsgate.example.pipeline

import net.degols.libs.cluster.Tools
import net.degols.libs.filesgate.orm.FileContent
import net.degols.libs.filesgate.pipeline.download.{DownloadApi, DownloadMessage}
import net.degols.libs.filesgate.utils.Tools
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.json.Json

import scala.concurrent.{Await, ExecutionContext, Future}

class Download(implicit val ec: ExecutionContext, tools: Tools) extends DownloadApi {
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  /**
    * @param downloadMessage
    * @return
    */
  override def process(downloadMessage: DownloadMessage): Future[DownloadMessage] = {
    logger.info(s"Should download ${downloadMessage.fileMetadata.url}. Time is ${Tools.datetime()}")

    tools.downloadFileInMemory(downloadMessage.fileMetadata.url).map(rawDownloadFile => {
      val duration = rawDownloadFile.end.getTime - rawDownloadFile.start.getTime
      val fileContent = new FileContent(downloadMessage.fileMetadata.id, rawDownloadFile.content.get)
      val downloadMetadata = Json.obj(
        "download_start_time" -> Json.obj("$date" -> rawDownloadFile.start.getTime),
        "download_duration_ms" -> duration,
        "size_bytes" -> Json.obj("$numberLong" -> rawDownloadFile.size)
      )
      downloadMessage.fileMetadata.downloaded = true
      downloadMessage.fileMetadata.metadata = downloadMessage.fileMetadata.metadata ++ downloadMetadata
      DownloadMessage(downloadMessage.fileMetadata, downloadMessage.abort, Option(fileContent))
    })
  }
}
