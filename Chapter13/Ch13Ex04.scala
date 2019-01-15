object Main extends App {  def stringIndices(coll: Array[String], m: Map[String, Int]): Array[Int] = {
    // Hehe, foldLeft stuck in my head, that's why came up with ugly option first:
    //res10.foldLeft(Array[Option[Int]]())((a, elem) => a :+ res6.get(elem)).flatMap(x => x)

    // But then realised that it's actually mappable operation:
    coll.flatMap(m.get(_))
  }

  println(stringIndices(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(", "))
}
