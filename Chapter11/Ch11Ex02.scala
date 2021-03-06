class MyNum(val myVal: Double) {
  def **(a: Int): Double = {
    if (a < 0)
      1 / (myVal * **(-a-1))
    else if (a == 0) 
      1
    else if (a == 1)
      myVal
    else
      myVal * **(a-1) 
  }

  // to test problems with postfix operators
  def *+ = {
    "Test" 
  }
}

object Main extends App {
  val num = new MyNum(2)

  /*
    Could not use construction "**num(3)" since only +, -, ~, ! in Scala are working
    as a prefix unary operators converting to num._**(3).
  */
  println(s"2 pow 3 = ${num **(3)}")
  println(s"2 pow 0 = ${num **(0)}")
  println(s"2 pow 1 = ${num **(1)}")
  println(s"2 pow -3 = ${num **(-3)}")

  /*
    Seems that Scala problems related to postfix operators (requiring "-language:postfixOps"
    therefore) are applicable only to postfix operators without arguments - 
    
  num *+
    
    so, this cannot be listed as a reason.
  */

  /* 
    More important problem - postfix operators have lower priority than infix operators.
    Which will make first two lines possible, and third one - not possible.
  */
  println(num **(3) * num.myVal)
  println(num.myVal * num.myVal)
  //println(num.myVal * num **(3))
  println(num.myVal * num.**(3))

  println(num *+)

  /* Answer summary: 
 *    reason 1) - postfix operators have lower priority than infix.
 *    reason 2) - bad readability overall.
 */
}
