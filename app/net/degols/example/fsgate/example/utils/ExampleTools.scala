package net.degols.example.fsgate.example.utils

import net.degols.libs.filesgate.orm.FileMetadata

class UrlIterator(start: Long, max: Long) extends Iterator[FileMetadata] {
  var i: Long = start

  override def hasNext: Boolean = i < max

  override def next(): FileMetadata = {
    i += 1
    if (i == 5 && false) {
      // Invalid url for test
      FileMetadata(s"http://127.0.0.1:8000/img/image-$i.jpg")
    } else {
      FileMetadata(s"http://127.0.0.1:8000/img/image.jpg?n=$i")
      //FileMetadata(s"http://127.0.0.1/img/stuff.txt?n=$i")
    }
  }
}
