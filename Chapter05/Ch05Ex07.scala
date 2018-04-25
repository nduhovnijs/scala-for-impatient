/*
 * Primary constructor parameters:
 * 1) Parameter (withous val or var): 
 *      If used inside at least one method, it becomes object-private field.
 *      Otherwise, it's not saved as field and just used in code of primary constructor.
 * 2) val/var:  
 *      Are turned into fields.
 *
 * In this case, we need parameter that we'll be parsing.
 * Reason:  we don't need "name" field.
 */
class Person(name: String) {
  private val nameSplit = name.split(" ")

  private var _firstName = nameSplit(0)
  private var _lastName = nameSplit(1)

  def firstName = _firstName
  def lastName = _lastName
}

val john = new Person("John Doe")
println(john.firstName + " " + john.lastName)
val jane = new Person("Jane Smith")
println(jane.firstName + " " + jane.lastName)
