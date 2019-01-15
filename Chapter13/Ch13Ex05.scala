object Main extends App {
  // By task definition, we need to stick to reduceLeft.
  // However, it does not seem to be possible with non-String collection (it's possible with foldLeft).
  // So, function is of very narrow use:
  def mkStringCustom(coll: Array[String], separator: String) = {
    coll.reduceLeft(_ + separator ++ _)
  }

  println(mkStringCustom(Array("abc", "def", "hij"), " | "))
}
