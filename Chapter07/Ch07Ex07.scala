object Hello extends App {
  import scala.collection.JavaConverters._

  // whoa, crazy import inside assignment, took from 
  // https://github.com/rajeshpv/scala-for-impatient/tree/master/src/main/scala/exercise
  val javaMap = { 
    import java.util.{HashMap => JHashMap}
    new JHashMap[String, String]()
  }
  javaMap.put("key1", "value1")
  javaMap.put("key2", "value2")
  javaMap.put("key3", "value3")

  val scalaMap = { 
    import scala.collection.mutable.{HashMap => SHashMap}
    SHashMap[String, String]()
  }

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
