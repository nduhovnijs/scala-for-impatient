abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(args: BinaryTree*) extends BinaryTree

object Main extends App {
  def elemSum(l: BinaryTree): Int = l match {
    case Node(elems @ _*) => elems.map(elemSum _).sum
    case Leaf(value) => value
  }

  val l = Node(Leaf(3), Node(Node(Leaf(8), Leaf(2)), Leaf(5)))
  println(elemSum(l))
}
