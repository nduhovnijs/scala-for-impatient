class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) {
    this(0, 0, width)    
  }
  
  def this() {
    this(0, 0, 0)
  }
}

object Hello extends App {
  val mySquare1 = new Square(1, 1, 5)  
  val mySquare2 = new Square(6) 
  val mySquare3 = new Square()

  println(mySquare1)
  println(mySquare2)
  println(mySquare3)
}
