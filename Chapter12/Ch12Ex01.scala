/*
Write a function values(fun: (Int) => Int, low: Int, high: Int)
  that yields a collection of function inputs and outputs in a given range.
  For example, values(x => x * x, -5, 5) should produce a collection of pairs (-5, 25), (-4, 16), (-3, 9), . . . , (5, 25).
*/

object Main extends App {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for (x <- low to high) yield {
      (x, fun(x))
    }
  }

  println(values(x => x * x, -5, 5))
}
