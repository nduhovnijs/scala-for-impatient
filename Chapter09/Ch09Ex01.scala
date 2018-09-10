import scala.io.Source
import java.io.PrintWriter

object Main extends App {
  val source = Source.fromFile("sample.txt", "UTF-8")
  val allLinesArrayReverse = source.getLines.toArray.reverse
  source.close()

  val out = new PrintWriter("sample.txt")
  for (line <- allLinesArrayReverse) {
    out.println(line)
  }
  out.close()
}
