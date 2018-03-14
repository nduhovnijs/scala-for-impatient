def power(x: Float, n: Int): Float = {
  if (n > 0 && n % 2 == 0) {
    power(x, n / 2) * power(x, n / 2) 
  }
  else if (n > 0 && n % 2 == 1) {
    x * power(x, n - 1)
  }
  else if (n < 0) {
    1 / power(x, -n)
  }
  else {
    1
  }
}

println(power(2, 3))
println(power(2, 4))
println(power(2, 0))
println(power(2, -2))
