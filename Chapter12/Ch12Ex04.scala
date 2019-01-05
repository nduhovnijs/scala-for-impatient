/*
I don't agree that special case is needed for n < 1.
Special case is needed for n = 0, and here foldLeft really shines.
*/

object Main extends App {
  def fac(arg: Int): Option[Int] = {
    if (arg < 0)
      None
    else
      Some((1 to arg).foldLeft(1)(_ * _))
  }

  println(fac(-1))
  println(fac(0))
  println(fac(4))
}
