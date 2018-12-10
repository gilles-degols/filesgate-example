package net.degols.example.fsgate.example.pipeline

import net.degols.filesgate.libs.filesgate.orm.FileMetadata
import net.degols.filesgate.libs.filesgate.pipeline.source.{SourceApi, SourceSeed}

class Source extends SourceApi{
  override def process(sourceSeed: SourceSeed): Iterator[FileMetadata] = ???

  override def id: String = ???
}
