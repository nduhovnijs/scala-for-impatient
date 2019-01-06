object Main extends App {
  val a = Array("He", "used", "to", "say", "soulshine", "It's", "better", "than", "sunshine")
  val b = Array(2, 4, 2, 3, 9, 4, 6, 4, 8)
  val c = Array(2, 4, 2, 2, 9, 4, 6, 4, 8) // Intentional mistake

  def corresponds[A, B](strings: Array[A], lengths: Array[B], fun: (A, B) => Boolean) = {
    (strings zip lengths).map(arg => fun(arg._1, arg._2)).reduceLeft(_ && _)
  }

  /*
   Problem is seen clearly if "corresponds" is done with generics (had to take step ahead):
   without currying, I have to specify types for function explicitly, they cannot be
   determined from types of Arrays.

   I also could not find a way to use short form like "_: String.length == _: Int".
  */
  println(corresponds(a, b, (k: String, l: Int) => k.length == l))
  println(corresponds(a, c, (k: String, l: Int) => k.length == l))
}
