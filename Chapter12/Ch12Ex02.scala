object Main extends App {
  println(Array(-2, 29, 89, -8, 0, 3, 333, 2, 13).reduceLeft(_ max _))
}
