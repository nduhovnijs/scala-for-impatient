package object random {
  val a = 1664525 
  val b = 1013904223
  val n = 32
  // not to recalulate every time
  val twoPowN = scala.math.pow(2, n).toInt
  var previousInt:BigInt = 1
  
  def nextInt() = {
    previousInt = (previousInt * a + b) % twoPowN
    previousInt
  }

  def nextDouble() = nextInt().toDouble
  
  def setSeed(seed: Int) {
    previousInt = seed 
  }
}

object Hello extends App {
  random.setSeed((System.currentTimeMillis() / 1000).toInt)
  for (i <- 0 to 9) println(random.nextInt())
  for (i <- 0 to 9) println(random.nextDouble())
}
