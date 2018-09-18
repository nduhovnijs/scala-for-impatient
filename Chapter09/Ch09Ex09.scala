import java.nio.file._

object Main extends App {
  // thanks https://alvinalexander.com/scala/scala-shell-script-command-line-arguments-args :)
  if (args.length == 0) {
    println("dude, i need at least one parameter")
  } else {
    val dirPath = args(0)
    val entries = Files.walk(Paths.get(dirPath))
    val classTypeRegex = """^.\.class*$""".r
    var counter = 0

    try {
      entries.forEach(p => if (p.toString.matches("""^.*\.class$""")) counter += 1)
    } finally {
      entries.close()
    }

    println(counter)
  }
}
