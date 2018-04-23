import scala.beans.BeanProperty

class Student {
  @BeanProperty var name: String = ""
  @BeanProperty var id: Long = 0
}

// proof that you can call Bean getters and setters from Scala
val nick = new Student()
nick.setName("Nick")
println(nick.getName())

// Try to call from SCALA

/*
 * output of javap
 *
  public class Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public long id();
  public void id_$eq(long);
  public long getId();
  public java.lang.String getName(); 
  public void setId(long);
  public void setName(java.lang.String);
  public Student();
  }

  ---

  Renerated are getId(), getName(), setId(), setName().

  No, you shouldn't use getters and setters in Scala.
  According to Scala, client shouldn't know if it's property or implementation.

*/
