object RGBCubeCorners extends Enumeration {
  /*
  * 1 - Yellow 255,255,0
  * 2 - White 255,255,255
  * 3 - Magenta 255,0,255
  * 4 - Red 255,0,0
  * 5 - Cyan 0,255,255
  * 6 - Blue 0,0,255
  * 7 - Green 0,255,0
  * 8 - Black 0,0,0
  */

  val Corner1 = Value(0xffff00, "Yellow")
  val Corner2 = Value(0xffffff, "White")
  val Corner3 = Value(0xff00ff, "Magenta")
  val Corner4 = Value(0xff0000, "Red")
  val Corner5 = Value(0x00ffff, "Cyan")
  val Corner6 = Value(0x0000ff, "Blue")
  val Corner7 = Value(0x00ff00, "Green")
  val Corner8 = Value(0x000000, "Black")
}

object Hello extends App {
  val myColor1 = RGBCubeCorners.Corner1
  println(s"myColor1 is ${myColor1}")
  println(s"All colors are ${RGBCubeCorners.values.mkString(", ")}") 
  println(s"Getting white color by id: ${RGBCubeCorners(0xffffff)}")
  println(s"Getting cyan color by name: ${RGBCubeCorners.withName("Cyan")}")
  println(s"Now getting all colors with ids:")
  for (corner <- RGBCubeCorners.values) {
    println(f"${corner.id}%#08x: ${corner}")
  }
}
