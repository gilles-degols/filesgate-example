package net.degols.example.fsgate.example.pipeline

import net.degols.libs.filesgate.orm.FileMetadata
import net.degols.libs.filesgate.pipeline.datasource.{DataSourceApi, DataSourceSeed}

class Source extends DataSourceApi{
  override def process(sourceSeed: DataSourceSeed): Iterator[FileMetadata] = {
    (1 to 10).map(number => FileMetadata(s"http://localhost:8000/img/image.jpg?n=${number}")).toIterator
  }
}
