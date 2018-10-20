/* 
Make silly trait hierarchy demonstrating
1) +layered traits
2) +concrete methods
3) +abstract methods
4) +concrete fields
5) +abstract fields
*/

trait Gift {
  def decorate(recepient: String)
  val description: String
}

trait Wrapping {
  def wrap(msg: String)
}

trait BaseWrappingPaper {
  def wrap(msg: String) {
    println(s"$msg, base wrapping paper")
  }
}

trait GreenWrappingPaper extends BaseWrappingPaper {
  override def wrap(msg: String) {
    super.wrap(s"$msg, green wrapping paper")
  }
}

trait PurpleWrappingPaper extends BaseWrappingPaper {
  override def wrap(msg: String) {
    super.wrap(s"$msg, purple wrapping paper")
  }
}

abstract class Pillow extends Gift with Wrapping {
  val description = "a fantatic sleeping gadget"
  
  def decorate(text: String) {
    wrap(s"Sign '$text, it's $description'")
  }
}

object Main extends App {
  val giftOne = new Pillow with GreenWrappingPaper with PurpleWrappingPaper
  giftOne.decorate("Congrats John")
  val giftTwo = new Pillow with PurpleWrappingPaper with GreenWrappingPaper
  giftOne.decorate("Congrats Jane")
}