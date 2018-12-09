package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.pipeline.download.{DownloadApi, DownloadMessage}
import net.degols.filesgate.libs.filesgate.pipeline.prestorage.PreStorageMessage

class Download extends DownloadApi{
  /**
    * @param downloadMessage
    * @return
    */
  override def process(downloadMessage: DownloadMessage): PreStorageMessage = ???

  override def id: String = ???
}
