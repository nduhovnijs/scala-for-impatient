import java.io._
import scala.collection.mutable.ArrayBuffer

@SerialVersionUID(42L) class Person(val name:String) extends Serializable {
  val friends = new ArrayBuffer[Person]
}

object Main extends App {
  val Alex = new Person("Alex")
  val Denis = new Person("Denis")
  val Ivan = new Person("Ivan")
  Alex.friends += Denis
  Alex.friends += Ivan
  Denis.friends += Alex
  val people = Array(Alex, Denis, Ivan) 

  val out = new ObjectOutputStream(new FileOutputStream("people.obj"))
  out.writeObject(people)
  out.close()

  val in = new ObjectInputStream(new FileInputStream("people.obj"))
  val restoredPeople = in.readObject().asInstanceOf[Array[Person]]
  in.close()

  for (person <- restoredPeople) {
    println(s"Name: ${person.name}")
    for (friend <- person.friends) println(s" Friend: ${friend.name}")
  }
}
