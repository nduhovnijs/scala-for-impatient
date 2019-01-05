/*
Conspect of useful higher-order functions:
* map - apply function to each element
* foreach - like map, but does not return value
* filter - yields elements that match particular condition
* reduceLeft - applies binary function to all elements of sequence
* sortWith - binary function for sorting
*/

/*
Modify the previous function to return the input at which the output is largest.
For example, largestAt(x => 10 * x - x * x, 1 to 10) should return 5.
Don’t use a loop or recursion.
*/

object Main extends App {
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    // Interesting that when tried to use "(_, fun(_)) instead of "elem => (elem, fun(elem))",
    // second element is Lambda function and not value. Stuff do not work therefore, because ">" in
    // reduceLeft is not defined for type "Int => Int".
    inputs.map(elem => (elem, fun(elem))).reduceLeft((a, b) => if (a._2 > b._2) a else b)._1
  }

  println(largest(x => 10 * x - x * x, 1 to 10))
}
