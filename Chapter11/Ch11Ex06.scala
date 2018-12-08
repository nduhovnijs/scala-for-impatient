class ASCIIArt(val fig: String) {
  def -(other: ASCIIArt) = {
    // Looking forward to see how can this section be rewritten in fancy way using maps
    val arr1 = fig.split("\n")
    val arr2 = other.fig.split("\n")

    var maxLineLength = 0
    for (line <- arr1)
      if (line.length > maxLineLength) maxLineLength = line.length

    val arrRes = for (lineNum <- 0 to (arr1.length-1)) yield {
      if (lineNum <= arr1.length && lineNum <= arr2.length) {
        arr1(lineNum) + (" " * (maxLineLength - arr1(lineNum).length)) + arr2(lineNum)
      } else if (lineNum <= arr1.length) {
        arr1(lineNum)
      } else {
        arr2(lineNum)
      }
    }

    new ASCIIArt(arrRes.mkString("\n"))
  }

  def |(other: ASCIIArt) = {
    new ASCIIArt(fig + "\n" + other)
  }

  override def toString = fig
}

object Main extends App {
  val figure1 = new ASCIIArt("""
     /\_/\
    ( ' ' )
    (  -  )
     | | |
    (__|__)
    """)

   val figure2 = new ASCIIArt("""
        ------
       / Hello \
      <  Scala |
       \ Coder /
        ------
   """)

   println(figure1 | figure2)
   println(figure1 - figure2)
}
