class Person(var age: Int = 0) {
  if (age < 0) age = 0 
}

val fred = new Person(25)
println(fred.age)
val erik = new Person(-6)
println(erik.age)
