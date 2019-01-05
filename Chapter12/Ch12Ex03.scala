object Main extends App {
  def fac(arg: Int) = {
    (1 to arg).reduceLeft(_ * _)
  }

  println(fac(4))
}
