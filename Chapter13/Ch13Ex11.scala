import scala.io.Source
import scala.collection.immutable.HashMap

object Main extends App {
  val source = Source.fromFile("sample.txt", "UTF-8")
  val textString = source.mkString

  /*
  val frequencies = new scala.collection.mutable.HashMap[Char, Int]
  for (c <- textString.par) frequencies(c) = frequencies1.getOrElse(c, 0) + 1
  */

  // Code above is a terrible idea, because shared collection is mutated concurrently.
  // Results are not predictable, here's a proof by 2 launches producing different results:
  /*
    Map(e -> 369, S -> 6, n -> 200, n -> 9, w -> 43, h -> 166, z -> 4...
    Map(e -> 361, S -> 6, n -> 205, w -> 43, h -> 162, z -> 4...
  */

  // I've seen prettier function for merging collection, but it required knowledge of 'case' (next chapter).
  // So, came out with a bit ugly one :)
  val frequencies = textString.aggregate(HashMap[Char, Int]())(
    (coll, sym) => coll + (sym -> (coll.getOrElse(sym, 0) + 1)),
    (coll1, coll2) => (coll1.keySet ++ coll2.keySet).foldLeft(HashMap[Char, Int]())(
      (subColl, subKey) => subColl + (subKey -> (coll1.getOrElse(subKey, 0) + coll2.getOrElse(subKey, 0)))
    )
  )
}
