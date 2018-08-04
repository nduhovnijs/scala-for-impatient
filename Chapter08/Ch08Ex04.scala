import scala.collection.mutable.ListBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(override val price: Double, override val description: String) extends Item {
}

class Bundle extends Item {
  val items: ListBuffer[Item] = ListBuffer()

  def addItem(item: Item) {
    items += item
  }

  override def price = {
    var bundlePrice: Double = 0
    for (item <- items) {
      bundlePrice += item.price
    }  
    bundlePrice
  }
  
  override def description = s"Bundle of ${items.length} items"
}

object Hello extends App {
  val XBox = new SimpleItem(500, "Video game console")
  println(s"XBox: ${XBox.description}, ${XBox.price}")

  val appleWatch = new SimpleItem(400, "Smartwatch")
  val iPhone = new SimpleItem(700, "Smartphone")
  val appleGadgets = new Bundle()
  appleGadgets.addItem(appleWatch)
  appleGadgets.addItem(iPhone)
  println(s"appleGadgets: ${appleGadgets.description}, ${appleGadgets.price}")
  println(appleGadgets.printDescr)
}
