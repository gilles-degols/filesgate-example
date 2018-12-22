package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.pipeline.storage.{StorageApi, StorageMessage}

class Storage extends StorageApi{
  override def process(storeMessage: StorageMessage): StorageMessage = storeMessage
}
