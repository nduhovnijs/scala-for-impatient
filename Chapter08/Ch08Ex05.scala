class Point(var x: Int = 0, var y: Int = 0) {
}

class LabeledPoint(var label: String, x: Int, y: Int) extends Point(x, y) {
  
}

object Hello extends App {
  val point = new Point(2, 5) 
  println(s"point: ${point.x}, ${point.y}")
  
  val labeledPoint = new LabeledPoint("some label", 3, 6)
  println(s"labeledPoint: ${labeledPoint.label}, ${labeledPoint.x}, ${labeledPoint.y}")
}
