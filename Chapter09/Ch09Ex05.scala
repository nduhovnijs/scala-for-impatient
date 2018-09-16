import java.io.PrintWriter
import scala.math.pow

object Main extends App {
  val out = new PrintWriter("sample_r.txt")
  for (i <- 0 to 20) {
    val powOfTwo = pow(2,i)
    val recipcoral = 1 / pow(2,i) 
    out.println(f"${powOfTwo}%7.0f    ${recipcoral}")
  }
  out.close()
}
