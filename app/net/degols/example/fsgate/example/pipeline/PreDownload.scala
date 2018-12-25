package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.predownload.{PreDownloadApi, PreDownloadMessage}

import scala.concurrent.{ExecutionContext, Future}

class PreDownload(implicit val ec: ExecutionContext) extends PreDownloadApi{
  /**
    * @param preDownloadMessage
    * @return
    */
  override def process(preDownloadMessage: PreDownloadMessage): Future[PreDownloadMessage] = Future{preDownloadMessage}
}
