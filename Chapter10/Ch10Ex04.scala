trait Logger {
  def log(msg: String)
}

trait CryptoLogger extends Logger {
  val key = 3

  def encryptToCaesars(msg: String): String = {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for (c <- msg) yield {
      var index = alphabet.indexOf(c)
      if (index != -1) {
        alphabet(((index - key) + alphabet.length) % alphabet.length)
      } else {
        c
      }
    }
  }

  override def log(msg: String) {
    println(encryptToCaesars(msg))
  }
}

abstract class Person(val id: String) extends Logger {
  def logId() {
    log(id)
  }
}

object Main extends App {
  val subjectX = new Person("UNCLE IGOR") with CryptoLogger
  subjectX.logId()

  val subjectY = new { override val key = 5 } with Person("FRIEND OF UNCLE IGOR") with CryptoLogger
  subjectY.logId()
}
