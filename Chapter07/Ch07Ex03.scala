package object random {
  val a = 1664525 
  val b = 1013904223
  val n = 32
  // not to recalulate every time
  val twoPowN = scala.math.pow(2, n).toInt
  var previousInt:BigInt = 1
  
  def nextInt() = {
    previousInt = (previousInt * a * b) % twoPowN
    previousInt
  }

  def nextDouble() = {
  }
  
  def setSeed(seed: Int) {
    previousInt = seed 
  }
}

object Hello extends App {
  for (i <- 0 to 9) println(random.nextInt())
}
