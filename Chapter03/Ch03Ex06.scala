import scala.collection.mutable.ArrayBuffer

val a = Array(-5, 1, 999, -1355, -1003)
println((a.sortWith(_ > _)).mkString(", "))

val ab = ArrayBuffer(-5, 1, 999, -1355, -1003)
println((ab.sortWith(_ > _)).mkString(", "))
