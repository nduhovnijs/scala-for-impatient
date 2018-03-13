def signum(arg: Int) = {
  if (arg < 0) -1
  else if (arg == 0) 0
  else 1
}

println(signum(-10))
println(signum(0))
println(signum(10))
