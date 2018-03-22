def swapAdjacent[A](a: Array[A]) = {
  val res = for (i <- a.indices) yield {
    if (i % 2 == 0) { 
      if (i < a.length - 1)
        a(i + 1) 
      else
        a(i)
    } 
    else {
      a(i - 1)
    }
  }
  res
}

val a = Array(1, 2, 3, 4, 5)
println(swapAdjacent(a).mkString(", "))

val b = Array("a", "b", "c", "d", "e", "f")
println(swapAdjacent(b).mkString(", "))
