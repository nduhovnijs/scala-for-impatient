import scala.collection.mutable.SortedSet

object Main extends App {
  // Using SortedSet to ensure order
  def getIndexes(str: String): Map[Char, SortedSet[Int]] = {
    // Task formulation itself prescribes to use mutable map.
    str.indices.foldLeft(Map[Char, SortedSet[Int]]())((m, i) =>
      { m + (str(i) -> (m.getOrElse(str(i), SortedSet[Int]()) + i)) })
  }

  println(getIndexes("Mississippi"))
}
