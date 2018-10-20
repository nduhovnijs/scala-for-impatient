import java.io.FileInputStream
import java.io.BufferedInputStream

trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  def log(msg: String) { println(msg) }
}

trait TimestampLogger extends ConsoleLogger {
  override def log(msg: String) {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}

trait ShortLogger extends ConsoleLogger {
  override def log(msg: String) {
    super.log(
      if (msg.length <= 15) msg else s"${msg.substring(0,12)}..."
    )
  }
}

trait MyBufferedInputStream extends TimestampLogger with ShortLogger {
  this: FileInputStream =>
    private val bis = new BufferedInputStream(this)
    
    override def read(): Int = {
      val res = bis.read()
      // Idea of calculation below:
      // Available bytes in BufferedInputStream are always 100% accurate (they decrease after every read).
      // Available bytes in FileInputStream are decreased in chunks (after each chunk beaing read).
      log(s"Buff: ${(bis.available - this.available)}")
      res
    }
}

object Main extends App {
  val fis = new FileInputStream("WarAndPeace.txt") with MyBufferedInputStream
  
  var c = fis.read()
  while(c != -1) {
    c = fis.read()
  }

  fis.close()
  fis.close()
}
