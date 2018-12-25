package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.poststorage.{PostStorageApi, PostStorageMessage}

import scala.concurrent.{ExecutionContext, Future}

class PostStorage(implicit val ec: ExecutionContext) extends PostStorageApi{
  /**
    * @param postStorageMessage
    * @return
    */
  override def process(postStorageMessage: PostStorageMessage): Future[PostStorageMessage] = Future{postStorageMessage}
}
