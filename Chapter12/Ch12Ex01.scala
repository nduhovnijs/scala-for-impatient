object Main extends App {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for (x <- low to high) yield {
      (x, fun(x))
    }
  }

  println(values(x => x * x, -5, 5))
}
