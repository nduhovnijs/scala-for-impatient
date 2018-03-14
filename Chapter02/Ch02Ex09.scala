def product(s: String):Long = {
  if (s.length > 1)
    s.head * product(s.tail)
  else 
    s(0).toLong
}

println(product("Hello"))
