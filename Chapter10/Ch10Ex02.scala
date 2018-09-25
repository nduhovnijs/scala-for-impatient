import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
  def compare(that: Point) = {
    if (this.x != that.x)
      this.x - that.x
    else 
      this.y - that.y
  }
}

object Main extends App {
  val p1 = new OrderedPoint(0, 0)
  val p2 = new OrderedPoint(0, 1)
  val p3 = new OrderedPoint(0, 0)

  println(p1 > p2)
  println(p1 >= p3)
  println(p2 > p3)
}
