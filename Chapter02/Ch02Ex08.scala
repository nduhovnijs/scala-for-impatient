def product(s: String) = {
  s.foldLeft[Long](1)(_ * _)
}

println(product("Hello"))
