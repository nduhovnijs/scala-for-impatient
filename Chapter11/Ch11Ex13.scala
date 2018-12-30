import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.language.dynamics

class XMLElement(val name: String, val value: String = "", val attributes: Map[String, String] = Map()) extends Dynamic {
  val children: ListBuffer[XMLElement] = ListBuffer()

  def selectDynamic(name: String): XMLElement = {
    children.find(x => x.name == name) match {
      case Some(i) => i
      case None => new XMLElement("notFound")
    }
  }

  def applyDynamicNamed(name: String)(args: (String, String)): XMLElement = {
    children.find(x => (x.name == name) && (x.attributes(args._1) == args._2)) match {
      case Some(i) => i
      case None => new XMLElement("notFound")
    }
  }

  override def toString = s"${name}: ${value}"
}

class XMLBuilder extends Dynamic {
  def applyDynamicNamed(elemName: String)(args: (String, String)*): XMLElement = {
    //todo: rewrite to args without map
    //todo: consider getting rid of listbuffer
    val attrs = Map[String, String]()
    for ((k, v) <- args)
      attrs(k) = v
    new XMLElement(name = elemName, attributes = attrs)
  }
}

/*
<html>
  <body>
    <ul id="42">
      <li>Hey you</li>
    </ul>
    <ul id="43">
      <li>Out there in the cold getting lonely getting old can you feel me?</li>
  </body>
</html>
*/

// TODO: check if chain not exists

object Main extends App {
  val builder = new XMLBuilder
  val myElem = builder.ul(id="42", style="list-style: lower-alpha;")
  println(s"${myElem}, ${myElem.attributes("style")}")

  /*
  val ul42 = new XMLElement(name = "ul", attributes = Map("id" -> "42"))
  ul42.children += new XMLElement(name = "li", value = "Hey you")

  val ul43 = new XMLElement(name = "ul", attributes = Map("id" -> "43"))
  ul43.children += new XMLElement(name = "li", value = "Out there in the cold getting lonely getting old can you feel me?")

  val body = new XMLElement(name = "body")
  body.children += ul42
  body.children += ul43

  val html = new XMLElement(name = "html")
  html.children += body

  val rootElement = new XMLElement(name = "rootElement")
  rootElement.children += html

  val pretest = rootElement.html.body.ul(id="42").li
  println(pretest)
  */
}
