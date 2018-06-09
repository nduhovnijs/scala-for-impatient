import scala.collection.JavaConverters._
import java.util.{HashMap => JHashMap}
import scala.collection.mutable.{HashMap => SHashMap}

object Hello extends App {
  val javaMap = new JHashMap[String, String]()
  javaMap.put("key1", "value1")
  javaMap.put("key2", "value2")
  javaMap.put("key3", "value3")

  val scalaMap = SHashMap[String, String]()

  //for (k <- javaMap.keySet().asScala) {
  //  scalaMap += (k -> javaMap.get(k))
  //}
  for ((k, v) <- javaMap.asScala) {
    scalaMap += (k -> v)
  }

  for ((k, v) <- scalaMap) {
    println(s"${k} -> ${v}")
  }
}
