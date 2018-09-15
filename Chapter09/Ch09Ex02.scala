import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer

object Main extends App {
  val source = Source.fromFile("sample.txt", "UTF-8")
  val lines = for (line <- source.getLines.toArray) yield line.split("\t")
  source.close()

  val columnsWidths = new ArrayBuffer[Int]()

  for (line <- lines) {
    for (i <- 0 until line.length) {
      if (i >= columnsWidths.length) {
        columnsWidths += line(i).length 
      } else {
        if (columnsWidths(i) < line(i).length)
          columnsWidths(i) = line(i).length
      } 
    }
  }
  
  val out = new PrintWriter("sample_r.txt")
  for (line <- lines) {
    val replacedLine = for (i <- 0 until line.length) yield { 
      line(i) + (" " * (columnsWidths(i) - (line(i).length)))
    } 
    out.println(replacedLine.mkString(" "))
  }
  out.close()
}
