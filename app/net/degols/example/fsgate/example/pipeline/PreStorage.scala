package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.prestorage.{PreStorageApi, PreStorageMessage}

import scala.concurrent.{ExecutionContext, Future}

class PreStorage(implicit val ec: ExecutionContext) extends PreStorageApi{
  /**
    * @param preStorageMessage
    * @return
    */
  override def process(preStorageMessage: PreStorageMessage): Future[PreStorageMessage] = Future{preStorageMessage}
}
