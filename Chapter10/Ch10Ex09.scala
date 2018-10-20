import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.BufferedInputStream

trait MyBufferedInputStream {
  this: FileInputStream =>
    private val bis = new BufferedInputStream(this)
    
    override def read(b: Array[Byte]): Int = {
      bis.read(b)
    }
}

object Main extends App {
  val fis = new FileInputStream("WarAndPeace.txt") with MyBufferedInputStream
  val isr = new InputStreamReader(fis, "UTF8")
  
  var c = isr.read()
  while(c != -1) {
    println(c.toChar)
    c = isr.read()
  }

  isr.close()
  isr.close()
}