def lteqgt(values: Array[Int], v: Int) = {
  (values.count(_ < v), values.count(_ == v), values.count(_ > v))
}

val a = Array(3, 2, -3, 1, 5, 10, -3)

println(f"${lteqgt(a, 0)}")
