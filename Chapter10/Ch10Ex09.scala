import java.io.FileInputStream
import java.io.BufferedInputStream

trait MyBufferedInputStream {
  this: FileInputStream =>
    private val bis = new BufferedInputStream(this)
    
    override def read(): Int = {
      bis.read()
    }
}

object Main extends App {
  val fis = new FileInputStream("WarAndPeace.txt") with MyBufferedInputStream
  
  var c = fis.read()
  while(c != -1) {
    println(c.toChar)
    c = fis.read()
  }

  fis.close()
  fis.close()
}