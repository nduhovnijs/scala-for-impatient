object Main extends App {
  def convertToTwoDim(arr: Array[Double], col: Int) = {
    arr.grouped(col).toArray
  }

  println(convertToTwoDim(Array(1, 2, 3, 4, 5, 6), 3).deep)
}
