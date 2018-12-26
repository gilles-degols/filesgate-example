package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.postmetadata.{PostMetadataApi, PostMetadataMessage}
import net.degols.libs.filesgate.pipeline.premetadata.{PreMetadataApi, PreMetadataMessage}

import scala.concurrent.{ExecutionContext, Future}

class PostMetadata(implicit val ec: ExecutionContext) extends PostMetadataApi {
  /**
    * @param postStorageMessage
    * @return
    */
  override def process(postMetadataMessage: PostMetadataMessage): Future[PostMetadataMessage] = Future{postMetadataMessage}
}

