object Main extends App {
  def fac(arg: Int): Option[Int] = {
    if (arg < 0)
      None
    else if (arg == 0)
      Some(1)
    else
      Some((1 to arg).reduceLeft(_ * _))
  }

  println(fac(-1))
  println(fac(0))
  println(fac(4))
}
