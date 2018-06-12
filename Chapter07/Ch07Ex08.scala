/*
What's effect of
import java._
import javax._
?
Is it a good idea?

Not good.
First of all, it will not give any signal of what's actually used.
Next, I doubt that using that much of Java from Scala program can be considered good practice.
Next, it can (not likely, but) create collisions with your own packages. Tried that, it will comp
ile, but it will be hard to say which class is actually chosen.
But probably most important that both java. and javax. contain some of same packages - like sql. So it won't compile in cases when those are used!
*/

package nik {
  package sql {
    // this one will not be used - import in object Test will have higher priority
    class Date(val dummy: Long) {
    }
  }

  object Test {
    // comment out the following to use Date from nik.sql
    import java._
    // uncomment to get compilation error because of collision
    //import javax._     

    val c = new sql.Date(123L)
    println(c.getClass)
  }
}

object Hello extends App {
  // Answer: it's not too good because of namespace cluttering.
  // For example, the following will not compile because Currency is 
  // already defined in java.util. 

  val t = nik.Test
}
