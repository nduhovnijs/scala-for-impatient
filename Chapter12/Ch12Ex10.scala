object Main extends App {
  def unless(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
    }
  }

  unless (3 == 5) { println("to be printed") }
  unless (3 == 3) { println("not to be printed") }

  /*
  1) In case of "unless", first parameter not necessary must be call-by-name, because in
  body of "until" nothing will alter outcome of expression (as opposed to "until" implementation).
  2) Currying is not necessary, but makes things prettier.
  */
}
