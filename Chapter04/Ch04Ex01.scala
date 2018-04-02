val gizmos = Map("Daydream View" -> 99.99, "Pixel Fabric Case" -> 39.99, "Xbox One X" -> 499.99)
val gizmosDiscount = for ((name, price) <- gizmos) yield (name, price * 0.9)
println(gizmosDiscount.mkString(", "))
