val in = new java.util.Scanner(new java.io.File("Ch04Ex02input.txt"))
val words = scala.collection.mutable.Map[String, Int]()

while (in.hasNext()) {
  val next = in.next()
  words(next) = words.getOrElse(next, 0) + 1
}

println(words.mkString("\n"))
