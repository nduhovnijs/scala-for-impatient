object Main extends App {
  def adjustToPair(fun: (Int, Int) => Int) = (pair: (Int, Int)) => fun(pair._1, pair._2)

  println(adjustToPair(_ * _)((6, 7)))
  println(((1 to 10) zip (11 to 20)).map(adjustToPair(_ + _)))
}
