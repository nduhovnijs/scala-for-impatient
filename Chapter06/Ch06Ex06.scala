object CardSuit extends Enumeration {
  val Hearts = Value("♥")
  val Clubs = Value("♣")
  val Spades = Value("♠")
  val Diamonds = Value("♦")
}

object Hello extends App {
  println("Hearts: " + CardSuit.Hearts)
  println("Clubs: " + CardSuit.Clubs)
  println("Spades: " + CardSuit.Spades)
  println("Diamonds: " + CardSuit.Diamonds)

  println("All suits: " + CardSuit.values)
}
