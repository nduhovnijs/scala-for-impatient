import scala.io.Source

object Main extends App {
  // Excercise: Write a Scala program that reads a text file and prints all tokens in the file that are not floating-point numbers. Use a regular expression.
  // 
  // My testing set:
  //    2.3 2 3.123 1354132.1 0 1.223 k -522
  //    3 232 .123 mm 0.0 1.22n3 nim -5.0 a
  //
  // After spending whole freaking evening re-reading stuff on Regexes (thanks https://www.rexegg.com/regex-lookarounds.html),
  // losing hope and experimenting, I've came up with 
  //    (?:\s|^)((?!-?\d+\.\d+(?:\s|$))\S+)
  // It does the following: 
  //    1) Search for space or beginning of line
  //    2) Once encountered, do a negative lookahead (make sure that sequence is not encountered after space or beginning of line) for "possible minus sign, decimals, point, decimals, space or end of line"
  //    3) If negative lookahead failed, match following non-space characters
  //
  //  Yes, I do understand that I could do inversion in code.
  //  But making it with Regex alone looked like a nice challenge.
  val myRegex = """(?:\s|^)((?!-?\d+\.\d+(?:\s|$))\S+)""".r

  val source = Source.fromFile("sample.txt", "UTF-8")
  val sourceCode = source.mkString
  source.close()

  for (m <- myRegex.findAllMatchIn(sourceCode)) println(m.group(1))
}
