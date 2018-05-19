object CardSuits extends Enumeration {
  val Hearts = Value("♥")
  val Clubs = Value("♣")
  val Spades = Value("♠")
  val Diamonds = Value("♦")
}

object Hello extends App {
  println("Hearts: " + CardSuits.Hearts)
  println("Clubs: " + CardSuits.Clubs)
  println("Spades: " + CardSuits.Spades)
  println("Diamonds: " + CardSuits.Diamonds)

  println("All suits: " + CardSuits.values)
}
