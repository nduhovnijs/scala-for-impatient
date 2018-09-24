trait RectangleLike {
  /* Defining abstract methods as per task's formultaion.
  * IMO, it would be cooler to use Self Type here:
  *  this: java.awt.geom.Ellipse2D.Double =>
        def translate(x: Double, y: Double) {
        ...
  */
  def setFrame(xPos: Double, yPos: Double, xSize: Double, ySize: Double)  
  def getX(): Double
  def getY(): Double
  def getWidth(): Double
  def getHeight(): Double

  def translate(x: Double, y: Double) {
    setFrame(getX() + x, getY() + y, getWidth(), getHeight())
  }

  def grow(x: Double, y: Double) {
    setFrame(getX(), getY(), getWidth() + 2*x, getHeight() + 2*y)
  }
}

object Main extends App {
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  println(s"X: ${egg.getX()}, Y: ${egg.getY()}, width: ${egg.getWidth()}, height: ${egg.getHeight()}")
  egg.translate(10, -10) //translate by X points horizontally and by Y vertically
  println(s"X: ${egg.getX()}, Y: ${egg.getY()}, width: ${egg.getWidth()}, height: ${egg.getHeight()}")
  egg.grow(10, 20) //grow by 2*X points horizontally and by 2*Y vertically
  println(s"X: ${egg.getX()}, Y: ${egg.getY()}, width: ${egg.getWidth()}, height: ${egg.getHeight()}")
}
