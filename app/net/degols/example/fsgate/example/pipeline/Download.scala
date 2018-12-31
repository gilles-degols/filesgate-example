package net.degols.example.fsgate.example.pipeline

import net.degols.libs.cluster.Tools
import net.degols.libs.filesgate.orm.FileContent
import net.degols.libs.filesgate.pipeline.download.{DownloadApi, DownloadMessage}
import net.degols.libs.filesgate.utils.Tools
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.json.Json

import scala.concurrent.{Await, ExecutionContext, Future}

class Download(tools: Tools)(implicit override val ec: ExecutionContext) extends net.degols.libs.filesgate.pipeline.download.Download(tools) {
  private val logger: Logger = LoggerFactory.getLogger(getClass)

}
