import scala.io.Source

object Main extends App {
  val imgSrcRegex = """<img[^<]+src="([^"]+)"[^<]+>""".r
  val pageSource = Source.fromURL("https://fedoraproject.org", "UTF-8")
  val contents = pageSource.mkString 
  pageSource.close()

  for (m <- imgSrcRegex.findAllMatchIn(contents)) println(m.group(1))
}
