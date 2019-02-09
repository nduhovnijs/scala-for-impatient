abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

object Main extends App {
  def elemSum(l: BinaryTree): Int = l match {
    case Node(left, right) => elemSum(left) + elemSum(right)
    case Leaf(value) => value
  }

  val l = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  println(elemSum(l))
}
