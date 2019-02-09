/*
Extend the tree in the preceding exercise so that each nonleaf node stores an operator in addition to the child nodes.
Then write a function eval that computes the value. For example, the tree Click here to view code image
      +
    /| \
  *  2  -
 / \    |
3   8   5

has value (3 × 8) + 2 + (–5) = 21. Pay attention to the unary minus.
            24    26
*/


abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(operation: Char, args: BinaryTree*) extends BinaryTree

object Main extends App {
  def elemOperation(l: BinaryTree): Int = l match {
    case Node('+', elems @ _*) => elems.map(elemOperation _).sum
    case Node('*', elems @ _*) => elems.map(elemOperation _).reduceLeft(_ * _)
    case Node('/', elems @ _*) => elems.map(elemOperation _).reduceLeft(_ / _)
    case Node('-', elem) => -elemOperation(elem)
    case Node('-', elems @ _*) => elems.map(elemOperation _).reduceLeft(_ - _)
    case Leaf(value) => value
  }

  val l = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
  println(elemOperation(l))
}
