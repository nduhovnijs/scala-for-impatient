object Main extends App {
  val a = Array("He", "used", "to", "say", "soulshine", "It's", "better", "than", "sunshine")
  val b = Array(2, 4, 2, 3, 9, 4, 6, 4, 8)
  val c = Array(2, 4, 2, 3, 9, 4, 6, 4, 9) // Intentional mistake

  println(a.corresponds(b)(_.length == _))
  println(a.corresponds(c)(_.length == _))
}
