/*
Conspect of useful higher-order functions:
* map - apply function to each element
* foreach - like map, but does not return value
* filter - yields elements that match particular condition
* reduceLeft - applies binary function to all elements of sequence
* sortWith - binary function for sorting
*/

object Main extends App {
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    // I can't understand why form below is not working properly:
    // inputs.reduceLeft(fun(_) max fun(_))

    // But ok, it's even easier to read:
    inputs.map(fun(_)).reduceLeft(_ max _)
  }

  println(largest(x => 10 * x - x * x, 1 to 10))
}
