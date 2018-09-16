import scala.io.Source

object Main extends App {
  // Regex was built with negative lookaround effectively saying
  // "prior to parenthesis there should be no combination of non-backslashed followed by backslash":
  // (?<![^\\]\\)
  // Details here - https://www.regular-expressions.info/lookaround.html
  // Also - lazy mode of search was enabled with "?"
  val myRegex = """".*?(?<![^\\]\\)"""".r

  val source = Source.fromFile("Ch09Ex06.java", "UTF-8")
  val sourceCode = source.mkString
  // maybe it can be used without pre-breaking to lines?
  source.close()

  for (m <- myRegex.findAllIn(sourceCode)) println(m)
}
