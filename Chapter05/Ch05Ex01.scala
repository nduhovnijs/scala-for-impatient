class Counter {
  private var value = 0
  def increase() {
    if (value < Int.MaxValue) value += 1 
  }
  def current() = value
}

val myCounter = new Counter

for (i <- 0 to 2147483646) {
  myCounter.increase()
}
println(f"${myCounter.current}%d")
myCounter.increase()
println(f"${myCounter.current}%d")
