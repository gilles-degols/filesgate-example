package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.pipeline.prestorage.{PreStorageApi, PreStorageMessage}

class PreStorage extends PreStorageApi{
  /**
    * @param preStorageMessage
    * @return
    */
  override def process(preStorageMessage: PreStorageMessage): PreStorageMessage = ???

  override def id: String = ???
}
