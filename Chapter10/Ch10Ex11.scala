class IterableInputStream(filename: String) extends java.io.FileInputStream(filename) with Iterable[Byte] {
  override def iterator = new Iterator[Byte] {
    def hasNext = {
      available() > 0
    }

    def next() = {
      read().toByte
    }
  }
}

object Main extends App {
  val fis = new IterableInputStream("WarAndPeace.txt")
  for (c <- fis) println(c.toChar)
  fis.close()
}