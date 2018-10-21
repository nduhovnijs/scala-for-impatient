/* 

For analisys I'm using example from Ch10Ex10.

super.log of ShortLogger trait is translated to:
  41: invokeinterface #50,  2           // InterfaceMethod ShortLogger$$super$log:(Ljava/lang/String;)V
and there is
  public abstract void ShortLogger$$super$log(java.lang.String);

Actual implementation is in Main$$anon$1.class:
1) public void ShortLogger$$super$log(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokestatic  #28                 // InterfaceMethod TimestampLogger.log$:(LTimestampLogger;Ljava/lang/String;)V
       5: return

2) public void TimestampLogger$$super$log(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokestatic  #41                 // InterfaceMethod ConsoleLogger.log$:(LConsoleLogger;Ljava/lang/String;)V
       5: return 

This changes if traits are swapped in places for mixin.

*/

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
}
