/*
 * class Stack[A] protected (protected val elems: List[A])
 *
 * First "protected" word means that only this class or subclass instance can call constructor.
 * Secoms "protected" word means field "elems" to be accessible only by only this class or subclass.
 */

class Bird protected (protected val country: String) {
  // this would be required for at least some way of constructing Bird without subclasses
  def this() {
    this("Latvia")
  }
}

class OpenBird(country: String) extends Bird(country) {
  def openCountry = country
}

object Main extends App {
  // following line will throw error - object Main cannot access primary constructor
  //val myBird = new Bird("Estonia")
  val myBird = new OpenBird("Estonia")
  
  // following line will throw error - object Main cannot access protected field
  println(s"${myBird.openCountry}")
}
