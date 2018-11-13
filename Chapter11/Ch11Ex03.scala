class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

  override def toString = s"$num/$den"

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b)

  def +(other: Fraction) =
    new Fraction(num * other.den + other.num * den, den * other.den)

  def -(other: Fraction) =
    new Fraction(num * other.den - other.num * den, den * other.den)

  def *(other: Fraction) =
    new Fraction(num * other.num, den * other.den)

  def /(other: Fraction) =
    new Fraction(num * other.den, den * other.num)
}

object Main extends App {
  val a = new Fraction(2, -4)
  val b = new Fraction(9, 2)

  //val a = new Fraction(2, 4)
  //val b = new Fraction(4, 2)

  println(s"Fraction 1: $a")
  println(s"Fraction 2: $b")

  val sum = a + b
  println(s"Summation: $sum")

  val sub = a - b
  println(s"Subtraction: $sub")

  val mult = a * b
  println(s"Multiplication: $mult")

  val div = a / b
  println(s"Division: $div")
}
