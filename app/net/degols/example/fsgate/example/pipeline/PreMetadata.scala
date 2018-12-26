package net.degols.example.fsgate.example.pipeline


import net.degols.libs.filesgate.pipeline.premetadata.{PreMetadataApi, PreMetadataMessage}

import scala.concurrent.{ExecutionContext, Future}

class PreMetadata(implicit val ec: ExecutionContext) extends PreMetadataApi {
  /**
    * @param postStorageMessage
    * @return
    */
  override def process(preMetadataMessage: PreMetadataMessage): Future[PreMetadataMessage] = Future{preMetadataMessage}
}
