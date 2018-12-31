package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.postmetadata.{PostMetadataApi, PostMetadataMessage}
import net.degols.libs.filesgate.pipeline.premetadata.{PreMetadataApi, PreMetadataMessage}
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{ExecutionContext, Future}

class PostMetadata(implicit val ec: ExecutionContext) extends PostMetadataApi {
  private val logger: Logger = LoggerFactory.getLogger(getClass)

  /**
    * @param postStorageMessage
    * @return
    */
  override def process(postMetadataMessage: PostMetadataMessage): Future[PostMetadataMessage] = {
    Future{postMetadataMessage}
  }
}

