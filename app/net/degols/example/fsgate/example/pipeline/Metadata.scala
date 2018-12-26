package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.metadata.{MetadataApi, MetadataMessage}
import net.degols.libs.filesgate.pipeline.premetadata.{PreMetadataApi, PreMetadataMessage}

import scala.concurrent.{ExecutionContext, Future}

class Metadata(implicit val ec: ExecutionContext) extends MetadataApi {
  /**
    * @param postStorageMessage
    * @return
    */
  override def process(metadataMessage: MetadataMessage): Future[MetadataMessage] = Future{metadataMessage}
}

