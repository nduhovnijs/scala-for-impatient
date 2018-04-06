import scala.collection.JavaConverters._

val in = new java.util.Scanner(new java.io.File("Ch04Ex02input.txt"))
val wordCounts = new java.util.TreeMap[String, Int]().asScala

while (in.hasNext()) {
  val word = in.next()
  wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
}

println(wordCounts.mkString("\n"))
