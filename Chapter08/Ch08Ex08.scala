class Person(val name: String) {
  override def toString = s"${getClass.getName}[name=$name]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}

// val "name" is getting compiled to private field "name" + getter method.
// Bonus: if to add "-v" - it is seen that #num are referenced to Constant pool.

/*
haven-macbook:Chapter08 nduhovnijs$ javap -private -c Person.class
Compiled from "Ch08Ex08.scala"
public class Person {
  private final java.lang.String name;

  public java.lang.String name();
    Code:
       0: aload_0
       1: getfield      #13                 // Field name:Ljava/lang/String;
       4: areturn

  public java.lang.String toString();
    Code:
       0: new           #18                 // class java/lang/StringBuilder
       3: dup
       4: ldc           #19                 // int 7
       6: invokespecial #23                 // Method java/lang/StringBuilder."<init>":(I)V
       9: aload_0
      10: invokevirtual #27                 // Method getClass:()Ljava/lang/Class;
      13: invokevirtual #32                 // Method java/lang/Class.getName:()Ljava/lang/String;
      16: invokevirtual #36                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #38                 // String [name=
      21: invokevirtual #36                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: aload_0
      25: invokevirtual #40                 // Method name:()Ljava/lang/String;
      28: invokevirtual #36                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      31: ldc           #42                 // String ]
      33: invokevirtual #36                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: invokevirtual #44                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      39: areturn

  public Person(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #13                 // Field name:Ljava/lang/String;
       5: aload_0
       6: invokespecial #48                 // Method java/lang/Object."<init>":()V
       9: return
}
*/

/*
haven-macbook:Chapter08 nduhovnijs$ javap -private -c SecretAgent.class
Compiled from "Ch08Ex08.scala"
public class SecretAgent extends Person {
  private final java.lang.String name;

  private final java.lang.String toString;

  public java.lang.String name();
    Code:
       0: aload_0
       1: getfield      #14                 // Field name:Ljava/lang/String;
       4: areturn

  public java.lang.String toString();
    Code:
       0: aload_0
       1: getfield      #18                 // Field toString:Ljava/lang/String;
       4: areturn

  public SecretAgent(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: invokespecial #23                 // Method Person."<init>":(Ljava/lang/String;)V
       5: aload_0
       6: ldc           #25                 // String secret
       8: putfield      #14                 // Field name:Ljava/lang/String;
      11: aload_0
      12: ldc           #25                 // String secret
      14: putfield      #18                 // Field toString:Ljava/lang/String;
      17: return
}
*/
