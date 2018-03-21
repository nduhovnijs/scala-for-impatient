import scala.util.Random

def randomNumbers(n: Int) = {
  var a = new Array[Int](n)

  for (i <- 0 to n-1) 
    a(i) = Random.nextInt(n)
  a
}

val a = randomNumbers(10)
println(a.mkString(", "))
