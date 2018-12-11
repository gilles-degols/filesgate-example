package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.pipeline.poststorage.{PostStorageApi, PostStorageMessage}

class PostStorage extends PostStorageApi{
  /**
    * @param postStorageMessage
    * @return
    */
  override def process(postStorageMessage: PostStorageMessage): PostStorageMessage = postStorageMessage
}
