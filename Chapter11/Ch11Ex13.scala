import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.language.dynamics

class XMLElement(val name: String, var value: String = "", val attributes: Map[String, String] = Map()) extends Dynamic {
  val children: ListBuffer[XMLElement] = ListBuffer()

  def selectDynamic(name: String): XMLElement = {
    children.find(x => x.name == name) match {
      case Some(i) => i
      case None => new XMLElement("notFound")
    }
  }

  def add(elem: XMLElement): XMLElement = {
    children += elem
    this
  }

  override def toString = s"${name}: ${value}"
}

class XMLBuilder extends Dynamic {
  def applyDynamicNamed(elemName: String)(args: (String, String)*): XMLElement = {
    val attrs = Map[String, String]()
    for ((k, v) <- args)
      attrs(k) = v
    new XMLElement(name = elemName, attributes = attrs)
  }
}

object Main extends App {
  val builder = new XMLBuilder

  val ul1 = builder.ul(id = "42", style = "list-style: lower-alpha;")
  ul1.value = "test"
  println(s"${ul1}, ${ul1.attributes("style")}")

  // nested
  val ul2WithLi1 = builder.ul(id = "43", style = "list-style: lower-alpha;").add(builder.li(id = "431"))
  ul2WithLi1.li.value = "test2"
  println(s"${ul2WithLi1.li}")
}
