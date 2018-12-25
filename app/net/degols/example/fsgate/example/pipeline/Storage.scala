package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.storage.{StorageApi, StorageMessage}

import scala.concurrent.{ExecutionContext, Future}

class Storage(implicit val ec: ExecutionContext) extends StorageApi{
  override def process(storeMessage: StorageMessage): Future[StorageMessage] = Future{storeMessage}
}
