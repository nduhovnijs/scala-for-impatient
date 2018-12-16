import java.nio.file.Path
import java.nio.file.Paths
import java.io.File

object PathComponents {
  def unapplySeq(path: Path): Option[Seq[String]]  = {
    if (path.getNameCount() > 0) {
      val pathSeq = for (i <- 0 to path.getNameCount()-1) yield path.getName(i).toString
      Some(pathSeq)
    } else
      None
  }
}

object Main extends App {
  val path: Path = Paths.get("/home/nduhovnijs/readme.txt")
  val PathComponents(first, second, third) = path
  println(s"${first} ${second} ${third}")
}
