/*
class Employee(val name: String, val salary: Double)
{
  def this() { this("John Q. Public", 0.0) }
}
*/

class Employee {
  private var _name = "John Q. Public"
  var salary = 0.0

  def this(name: String, salary: Double) {
    this()
    _name = name
    this.salary = salary
  }
  
  def name = _name
  
  override def toString = s"${_name}: ${salary}"
}

val jack = new Employee("Jack", 100000)
println(jack)

val john = new Employee()
println(john)

// Fantastic! When I appeared to be confused on what is default primary constructor
// (I did guess correctly that it's the one without default parameters), I googled
// post of author of book himelf (Cay Horstmann)
// https://stackoverflow.com/questions/10426146/constructors-in-scala-primary-auxiliary-default-primary
// :)
//
// As for answer about which form is preferrable - ofc first one is more compact.
// Also, it feels more natural and allows to use val. So - first.
