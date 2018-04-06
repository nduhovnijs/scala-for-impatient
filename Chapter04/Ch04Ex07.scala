import scala.collection.JavaConverters._

val properties = java.lang.System.getProperties().asScala
var longest = 0
for ((k, v) <- properties) println(f"$k%s${" " * (longest - k.length)} | $v%s")
