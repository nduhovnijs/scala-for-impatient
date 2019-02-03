
//2. Using pattern matching, write a function swap that receives a pair of integers and returns the pair with the components swapped.

object Main extends App {
  def swap(pair: (Int, Int)) = pair match {
    case (a, b) => (b, a)
  }

  println(swap(1, 2))
}
