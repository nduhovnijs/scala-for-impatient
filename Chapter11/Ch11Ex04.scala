class Money(val totalCents: Int) {
  def this(dollars: Int, cents: Int) {
    this(dollars * 100 + cents)
  }

  override def toString() =
    s"${totalCents / 100}, ${totalCents % 100}"
  
  def +(other: Money) =
    new Money(totalCents + other.totalCents)

  def -(other: Money) =
    new Money(totalCents - other.totalCents)

  def ==(other: Money) =
    totalCents == other.totalCents

  def <(other: Money) = 
    totalCents < other.totalCents

  // I am to supply * and / operators, but with Int as argument.
  def *(multiplier: Int) =
    new Money(totalCents * multiplier)

  def /(divisor: Int) =
    new Money(totalCents / divisor)
}

object Main extends App {
  println(s"Test from excercise: ${new Money(1, 75) + new Money(0, 50) == new Money(2, 25)}")

  val sumA = new Money(15, 75) 
  println(s"Sum A is 15 dollars, 75 cents: ${sumA}")

  val sumB = new Money(15, 150)
  println(s"Sum B is 15 dollars, 150 cents: ${sumB}")

  println(s"SumA - SumB: ${sumA - sumB}")
  println(s"SumA == SumB: ${sumA == sumB}")
  println(s"SumA < SumB: ${sumA < sumB}")

  val sumC = new Money(14, 175)
  println(s"Sum C is 14 dollars, 175 cents: ${sumC}")

  println(s"SumA - SumC: ${sumA - sumC}")
  println(s"SumA - SumC: ${sumA == sumC}")
  println(s"SumA - SumC: ${sumA < sumC}")

  println(s"SumC / 2: ${sumC / 2}")
  println(s"SumC * 2: ${sumC * 2}")
}
