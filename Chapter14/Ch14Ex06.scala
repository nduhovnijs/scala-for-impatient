/*
A better way of modeling such trees is with case classes. Let’s start with binary trees.
Click here to view code image sealed
 Write a function to compute the sum of all elements in the leaves.
*/

abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

object Main extends App {
  def elemSum(l: BinaryTree): Int = l match {
    case Node(left, right) => elemSum(left) + elemSum(right)
    case Leaf(value) => value
  }

  val l = Node(Leaf(3), Node(Node(Leaf(8), Leaf(2)), Leaf(5)))
  println(elemSum(l))
}
