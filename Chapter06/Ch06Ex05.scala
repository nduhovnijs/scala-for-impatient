object Hello extends App {
  /*
  val reverseArgs = for (i <- 0 to args.length - 1; j = args.length - 1 - i) yield args(j)
  println(reverseArgs.mkString(" "))
  */
  // f*ck, it appeard that there's "reverse" function for arrays
  println(args.reverse.mkString(" "))
}
