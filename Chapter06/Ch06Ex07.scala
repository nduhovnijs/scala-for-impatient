object CardSuit extends Enumeration {
  type CardSuit = Value

  val Hearts = Value("♥")
  val Clubs = Value("♣")
  val Spades = Value("♠")
  val Diamonds = Value("♦")
}

object Hello extends App {
  // "CardSuit.CardSuit" construction is not that sexy, to be honest.
  // Used it and "type CardSuit = Value" above in respect to book, but I'd hardly see motivation
  // to use it in real life.
  def isSuiteRed(card: CardSuit.CardSuit) = {
    if (card == CardSuit.Hearts || card == CardSuit.Diamonds) true
    else false
  }

  val card1 = CardSuit.Hearts
  val card2 = CardSuit.Clubs

  println(s"Is card1 red? ${isSuiteRed(card1)}")
  println(s"Is card2 red? ${isSuiteRed(card2)}")
}
