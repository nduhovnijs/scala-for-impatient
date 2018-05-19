class Point(var x: Double, var y: Double) {
  override def toString = s"Coordinates are ${x}, ${y}"
}

object Point {
  def apply(x: Double, y: Double) = {
    new Point(x, y) 
  }
}

object Hello extends App {
  println(s"${Point(13,10)}")
}
