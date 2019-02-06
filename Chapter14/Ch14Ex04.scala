/*
4. Add a case class Multiple that is a subclass of the Item class. For example,
Multiple(10, Article("Blackwell Toaster", 29.95)) describes ten toasters.
Of course, you should be able to handle any items, such as bundles or multiples, in the second argument.
Extend the price function to handle this new case.
*/

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(amount: Int, position: Item) extends Item

object Main extends App {
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    case Multiple(amount, position) => amount * price(position)
  }

  println(
    price(
      Multiple(10, Bundle("Father's day special", 20.0,
        Multiple(10, Article("Scala for Impatient", 39.95)),
        Multiple(10, Bundle("Anchor Distillery Sampler", 10.0,
          Article("Old Potrero Straight Rye Whiskey", 79.95),
          Article("Junipero Gin", 32.95)))))
    )
  )
}
