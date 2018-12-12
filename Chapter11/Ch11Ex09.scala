import java.nio.file.Path
import java.nio.file.Paths

object PathComponents {
  def unapply(path: Path) = {
    if (path.getNameCount() > 0) Some(path.getParent(), path.getFileName()) else None
  }
}

object Main extends App {
  val path: Path = Paths.get("/home/nduhovnijs/readme.txt")
  val PathComponents(dirName, fileName) = path
  println(s"dir is ${dirName}, file is ${fileName}")
}
