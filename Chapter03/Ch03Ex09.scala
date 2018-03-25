import scala.collection.mutable.ArrayBuffer

def dropNegativeButFirst(a: ArrayBuffer[Int]) = {
  var negativeCount = -1
  var newPositions = new ArrayBuffer[Array[Int]]

  for (i <- a.indices) { 
    if (a(i) < 0) negativeCount += 1
    else if (negativeCount > 0) {
      newPositions += Array(i, i - negativeCount)
    } 
  }

  for (elem <- newPositions) a(elem(1)) = a(elem(0))
  if (negativeCount > 0) a.trimEnd(negativeCount)

  a
}

val ab = ArrayBuffer(333, 2, -1, 0, 44, -3, 44, -5, 100, -100, 2, 4, -32, 3, 0, -15)
println(ab.mkString(", "))
println(dropNegativeButFirst(ab).mkString(", "))
