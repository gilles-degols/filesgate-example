package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.predownload.{PreDownloadApi, PreDownloadMessage}

class PreDownload extends PreDownloadApi{
  /**
    * @param preDownloadMessage
    * @return
    */
  override def process(preDownloadMessage: PreDownloadMessage): PreDownloadMessage = preDownloadMessage
}
