import scala.language.dynamics

class DynamicProps(val props: java.util.Properties) extends Dynamic {
  /*def updateDynamic(name: String)(value: String) {
    props.setProperty(name.replaceAll("_", "."), value)
  }*/

  def selectDynamic(name: String): DynamicPropsHelper = {
    new DynamicPropsHelper(s"${name}", props)
  }

  /*def applyDynamicNamed(name: String)(args: (String, String)*) {
    if (name != "add") throw new IllegalArgumentException
    for((k, v) <- args)
      props.setProperty(k.replaceAll("_", "."), v)
  }*/
}

class DynamicPropsHelper(val name: String, val props: java.util.Properties) extends Dynamic {
  def selectDynamic(name: String): DynamicPropsHelper = {
    new DynamicPropsHelper(s"${this.name}.${name}", props)
  }

  override def toString = props.getProperty(this.name)
}

object Main extends App {
  val sysProps = new DynamicProps(System.getProperties)

  println(sysProps.java.vendor)
  println(sysProps.java.vendor.url)
}
