val in = new java.util.Scanner(new java.io.File("Ch04Ex02input.txt"))
val words = scala.collection.mutable.Map[String, Int]()

while (in.hasNext()) {
  val next = in.next()
  if (words.contains(next)) words(next) += 1
  else words(next) = 1
}

println(words.mkString("\n"))
