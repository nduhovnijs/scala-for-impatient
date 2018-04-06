val in = new java.util.Scanner(new java.io.File("Ch04Ex02input.txt"))
val wordCounts = scala.collection.mutable.SortedMap[String, Int]()

while (in.hasNext()) {
  val word = in.next()
  wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
}

println(wordCounts.mkString("\n"))
