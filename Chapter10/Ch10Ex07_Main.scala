object Main extends App {
  val acc = new SavingsAccount
  println(acc.balance)
  println(acc.interest)
  println(acc.loggerName)
}

/* 

Here's what happens:

java.lang.AbstractMethodError: Method SavingsAccount.ConsoleLogger$_setter_$loggerName_$eq(Ljava/lang/String;)V is abstract
	at SavingsAccount.ConsoleLogger$_setter_$loggerName_$eq(Ch10Ex07_SavingsAccount.scala)
	at ConsoleLogger.$init$(Ch10Ex07_ConsoleLogger.scala:3)
	at SavingsAccount.<init>(Ch10Ex07_SavingsAccount.scala:1)
	at Main$.delayedEndpoint$Main$1(Ch10Ex07_Main.scala:2)
	at Main$delayedInit$body.apply(Ch10Ex07_Main.scala:1)
  ...

Reason: ConsoleLogger is turned in JVM interface, it has only abstract LoggerName
getter and setter.

haven-macbook:Chapter10 nduhovnijs$ javap -private ConsoleLogger.class
Compiled from "Ch10Ex07_ConsoleLogger.scala"
public interface ConsoleLogger {
  public abstract void ConsoleLogger$_setter_$loggerName_$eq(java.lang.String);
  public static void log$(ConsoleLogger, java.lang.String);
  public void log(java.lang.String);
  public abstract java.lang.String loggerName();
  public static void $init$(ConsoleLogger);
}

AccountSavings after recompilation:
public class SavingsAccount extends Account implements ConsoleLogger {
  private final java.lang.String loggerName;
  public void log(java.lang.String);
  public java.lang.String loggerName();
  public void ConsoleLogger$_setter_$loggerName_$eq(java.lang.String);
  public SavingsAccount();
}

So, under the hood, class that mixes in traits receivs fields and getters/setters.

*/