import scala.io.Source

object Main extends App {
  val source = io.Source.fromFile("sample.txt", "UTF-8")
  val numbers = for (t <- source.mkString.split("\\s+")) yield t.toDouble
  source.close()

  val avg = numbers.sum / numbers.length
  println(s"Min: ${numbers.min}, Max: ${numbers.max}, Sum: ${numbers.sum}, Avg: ${avg}")
}
