object Main extends App {
  def swap(arr: Array[Int]) = arr match {
    case Array(first, second, rest @ _*) => Array(second, first) ++ rest
    case otherArr => otherArr
  }

  println(swap(Array(1)).mkString(" "))
  println(swap(Array(1, 2)).mkString(" "))
  println(swap(Array(1, 2, 3)).mkString(" "))
}
