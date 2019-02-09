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
