import scala.collection.mutable.ArrayBuffer

def dropNegativeButFirst(a: ArrayBuffer[Int]) = {
  val negativeIndices = for (i <- a.indices if a(i) < 0) yield i
  val indicesToRemove = negativeIndices.tail.reverse
  for (i <- indicesToRemove) a.remove(i)
  a
}

val ab = ArrayBuffer(333, 2, -1, 0, 44, -3, 44, -5, 100, -100, 2, 4, -32, 3, 0, -15)
println(ab.mkString(", "))
println(dropNegativeButFirst(ab).mkString(", "))
