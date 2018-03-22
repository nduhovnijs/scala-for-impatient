def swapAdjacent[A](a: Array[A]) {
  for (i <- a.indices if i % 2 == 1) {
    var tmp = a(i-1)  
    a(i-1) = a(i)
    a(i) = tmp
  }
}

val a = Array(1, 2, 3, 4, 5)
swapAdjacent(a)
println(a.mkString(", "))

val b = Array("a", "b", "c", "d", "e", "f")
swapAdjacent(b)
println(b.mkString(", "))
