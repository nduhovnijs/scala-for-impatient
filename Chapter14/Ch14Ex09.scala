object Main extends App {
  val l1 = List(Some(2), Some(1), None, Some(9), None, Some(5))
  val l2 = List(None, Some(1), None, Some(9), None, Some(5))

  def sum(l: List[Option[Int]]) = {
    l.foldLeft(0)((sum, elem) => { if (elem.isEmpty) sum else (sum + elem.get) } )
  }

  println(sum(l1))
  println(sum(l2))
}
