import java.lang.System._

object Hello extends App {
  val userName = getProperty("user.name")
  
  // It appeared that readLine is now in DeprecatedPredef.
  // So, it's better to use scala.io.readLine, even if it goes agains wording of excercise. 
  // Also, I'm not sure that there was no typo in excercise - it would be logical to expect that author wants us to work not with Scala's StdIn, but with Java's one.
  //val password = readLine("Would you kindly enter password: ")
  val password = scala.io.StdIn.readLine("Would you kindly enter password: ")
  if (password != "secret")
    err.println("Wrong password")
  else
    println("Welcome home – it's been too long, we've missed you!")
}
