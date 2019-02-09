object Main extends App {
  def elemSum(l: Any): Int = l match {
    case List(elems @ _*) => elems.map(elemSum _).sum
    case elem => elem.asInstanceOf[Int]
  }

  val l = List(List(3, List(8, 1)), 2, List(5))
  println(elemSum(l))
}
