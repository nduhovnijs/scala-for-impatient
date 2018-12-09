class BitSequence(var value: Long) {
  override def toString = f"${value.toBinaryString.toInt}%064d"

  def apply(pos: Int): Boolean = {
    if (f"${value.toBinaryString.toInt}%064d"(63-pos) == '0')
      false
    else
      true
  }

  def update(pos: Int, bit: Boolean) {
    if(bit) {
      value = value | (1 << pos)
    }
    else {
      value = value & ~(1 << pos)
    }
  }
}

object Main extends App {
  val bs = new BitSequence(25)
  println(s"Full: ${bs}")
  println(s"4th bit (counting from 0): ${bs(4)}")
  bs(9) = true
  println(s"Setting 9th (counting from 0) bit to true  ${bs}")
  bs(9) = false
  println(s"Setting 9th (counting from 0) bit to false ${bs}")
}
