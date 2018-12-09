class Matrix(val arr: Array[Array[Int]]) {
  override def toString = arr.deep.mkString

  def +(other: Matrix) = {
    if (!((arr.size == other.arr.size) && (arr(0).size == other.arr(0).size)))
      throw new IllegalArgumentException("Second matrix is not of the same size as first")

    val res = Array.ofDim[Int](arr.size, arr(0).size)
    for {
      i <- 0 to arr.size-1
      j <- 0 to arr(0).size-1
    } res(i)(j) = arr(i)(j) + other.arr(i)(j)

    new Matrix(res)
  }

  def *(scalar: Int) = {
    val res = for(row <- arr) yield
      for (elem <- row) yield elem * scalar
    new Matrix(res)
  }

  def *(other: Matrix) = {
    if (!(arr(0).size == other.arr.size))
      throw new IllegalArgumentException("Number of rows in second matrix does not match to number of columns in the first one")

    val res = Array.ofDim[Int](arr.size, arr.size)
    for {
      i <- 0 to arr.size-1
      j <- 0 to arr.size-1
      k <- 0 to arr(0).size-1
    } res(i)(j) +=  arr(i)(k) * other.arr(k)(j)
    new Matrix(res)
  }
}

object Main extends App {
  try {
    val matr1 = new Matrix(Array(Array(1, 2, 3), Array(4, 5, 6)))
    val matr2 = new Matrix(Array(Array(1, 2, 3), Array(4, 5, 6)))
    val matr3 = new Matrix(Array(Array(7, 8), Array(9, 10), Array(11, 12)))
    val matrFail = new Matrix(Array(Array(7, 8), Array(9, 10), Array(11, 12), Array(13, 14)))

    println(s"Sum of matrices: ${matr1 + matr2}")
    println(s"Multiplication of matrices: ${matr1 * matr3}")
    println(s"Scalar multiplication of matrix: ${matr1 * 3}")
    println(s"Failed multiplication of matrices: ${matr1 * matrFail}")
  } catch {
    case illegalArg: IllegalArgumentException => println(illegalArg.getMessage())
  }
}
