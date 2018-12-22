package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.cluster.Tools
import net.degols.filesgate.libs.filesgate.pipeline.download.{DownloadApi, DownloadMessage}
import net.degols.filesgate.libs.filesgate.pipeline.prestorage.PreStorageMessage
import net.degols.filesgate.libs.filesgate.utils.Tools
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

class Download(tools: Tools) extends DownloadApi{
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  /**
    * @param downloadMessage
    * @return
    */
  override def process(downloadMessage: DownloadMessage): DownloadMessage = {
    logger.info(s"Should download ${downloadMessage.fileMetadata.url}")
    Try{Await.result(tools.downloadFileInMemory(downloadMessage.fileMetadata.url), 10 seconds)} match {
      case Success(res) => logger.info(s"Downloaded file: ${res}")
      case Failure(err) => logger.info(s"Downloaded file failure: ${Tools.formatStacktrace(err)}")
    }
    downloadMessage
  }
}
