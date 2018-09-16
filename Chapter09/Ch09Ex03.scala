// It's tempting to write clean one-line solution, but then source will not be closed in the end.
//for (word <- io.Source.fromFile("sample.txt", "UTF-8").mkString.split("\\s+") if word.stripSuffix(".").length >= 12) println(word.stripSuffix("."))

val source = io.Source.fromFile("sample.txt", "UTF-8")
for (word <- source.mkString.split("\\s+") if word.stripSuffix(".").length >= 12) println(word.stripSuffix("."))
source.close()
