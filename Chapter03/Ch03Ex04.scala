def reorderArray(ar: Array[Int]) = {
  val positiveArray = (for (elem <- ar if elem >= 0) yield elem).sorted
  val negativeArray = (for (elem <- ar if elem < 0) yield elem).sorted

  positiveArray ++ negativeArray
}

println(reorderArray(Array(-3, 0, 23, 1, -100, 3, 9, 999, -2, -3)).mkString(", "))
