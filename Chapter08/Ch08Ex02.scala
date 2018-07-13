class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  var freeOperations = 3
  val interestRate = 0.001

  def earnMonthlyInterest { super.deposit(currentBalance * interestRate) }
  
  override def deposit(amount: Double) = {
    super.deposit(amount)
    if (freeOperations > 0) freeOperations -= 1
    else { freeOperations = 3; super.withdraw(1) } 
    currentBalance
  }
  
  override def withdraw(amount: Double) = {
    super.withdraw(amount)
    if (freeOperations > 0) freeOperations -= 1
    else { freeOperations = 3; super.withdraw(1) }
    currentBalance
  }
}

object Hello extends App {
  val a = new SavingsAccount(100)
  a.deposit(2)
  println(a.currentBalance) 
  a.deposit(2)
  println(a.currentBalance) 
  a.deposit(2)
  println(a.currentBalance)
  a.deposit(2)
  println(a.currentBalance)
  a.earnMonthlyInterest
  println(a.currentBalance)
  a.deposit(2)
  println(a.currentBalance)
}
