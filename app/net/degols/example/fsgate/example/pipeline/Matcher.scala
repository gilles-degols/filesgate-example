package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.orm.FileMetadata
import net.degols.filesgate.libs.filesgate.pipeline.matcher.MatcherApi

class Matcher extends MatcherApi{
  /**
    * @param fileMetadata
    * @return true if the current pipeline is meant to download the file, or not.
    */
  override def process(fileMetadata: FileMetadata): Boolean = ???

  override def id: String = ???
}
