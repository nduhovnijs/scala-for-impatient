/*
1) Basically, flatMap is needed to concatenate multiple vectors into one.

  Result of
    scala> (1 to 10).map(i => (1 to i).map(j => i * j))
  is
    res101: scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[Int]] = Vector(Vector(1), Vector(2, 4), Vector(3, 6, 9), Vector(4, 8, 12, 16), Vector(5, 10, 15, 20, 25), Vector(6, 12, 18, 24, 30, 36), Vector(7, 14, 21, 28, 35, 42, 49), Vector(8, 16, 24, 32, 40, 48, 56, 64), Vector(9, 18, 27, 36, 45, 54, 63, 72, 81), Vector(10, 20, 30, 40, 50, 60, 70, 80, 90, 100))
  So, to create single vector from vector of vectors, flatMap is used instead of Map.

2) I suppose, if third generator is added, it is converted to yet another flatMap wrapper.
  scala> for (i <- 1 to 5; j <- 1 to i; k <- 1 to j) yield i * j * k
  res108: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 4, 8, 3, 6, 12, 9, 18, 27, 4, 8, 16, 12, 24, 36, 16, 32, 48, 64, 5, 10, 20, 15, 30, 45, 20, 40, 60, 80, 25, 50, 75, 100, 125)

  scala> (1 to 5).flatMap(i => (1 to i).flatMap(j => (1 to j).map(k => i * j * k)))
  res107: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 4, 8, 3, 6, 12, 9, 18, 27, 4, 8, 16, 12, 24, 36, 16, 32, 48, 64, 5, 10, 20, 15, 30, 45, 20, 40, 60, 80, 25, 50, 75, 100, 125)
*/
