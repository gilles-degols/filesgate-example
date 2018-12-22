package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.datasource.{DataSourceApi, DataSourceSeed}

class Source extends DataSourceApi{
  override def process(sourceSeed: DataSourceSeed): Iterator[FileMetadata] = {
    (1 to 100).map(number => FileMetadata(s"http://localhost/img/$number")).toIterator
  }
}
