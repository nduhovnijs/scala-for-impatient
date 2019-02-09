object Main extends App {
  def f(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  def g(x: Double) = if (x >= 0) Some(scala.math.sqrt(x)) else None

  def compose(func1: (Double => Option[Double]), func2: (Double => Option[Double])) = {
    (x: Double) => (func1(x), func2(x)) match {
      case (Some(_), Some(_)) => func1(func2(x).get)
      case _ => None
    }
  }

  val h = compose(g, f)
  println(h(2))
  println(h(1))
  println(h(0))
}
