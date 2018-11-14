// This solution, on one hand, is short, but on the other - it does not add empty cells. 
// Example - on new line we add yet another column.
// That means we'd have to go back and add extra cells to every line.
// It's either ugly parsing of sting (not sure how), or have ArrayBuffer matrix pre-built.

class Table(val state: String) {
  def |(arg: String) = {
    new Table(s"${state}<td>${arg}</td>")
  }

  def ||(arg: String) = {
    new Table(s"${state}</tr><tr><td>${arg}</td>")
  }

  override def toString =
    s"<table><tr>${state}</tr></table>"
}

object Table {
  def apply() =
    new Table("")
}
  
object Main extends App {
  println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
}
