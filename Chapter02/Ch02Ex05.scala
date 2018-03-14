def countdown(n: Int) {
  if (n >= 0)
    for (i <- 0 to n; j = n - i) println(j)
  else
    for (i <- n to 0) println(i)
}

countdown(13)
println("---")
countdown(-13)
