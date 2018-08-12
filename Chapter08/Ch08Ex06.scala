abstract class Shape {
  def centerPoint: (Int, Int)
}

class Rectangle(var x: Int, var y: Int, var length: Int, var height: Int) extends Shape {
  override def centerPoint = {
    (length / 2 - x, height / 2 - y)
  }
}

class Circle(var x: Int, var y: Int, var radius: Int) extends Shape {
  override def centerPoint = {
    (2,2)
  }  
}

object Hello extends App {
  val rectangle = new Rectangle(0, 0, 6, 4)
  val circle = new Circle(3, 3, 6)
  println(s"rectangle: ${rectangle.centerPoint}") 
  println(s"circle: ${circle.centerPoint}")
}
