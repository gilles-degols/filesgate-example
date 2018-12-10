package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.pipeline.storage.{StorageApi, StoreMessage}

class Storage extends StorageApi{
  override def process(storeMessage: StoreMessage): StoreMessage = ???

  override def id: String = ???
}
