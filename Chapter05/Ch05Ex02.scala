class BankAccount {
  private var privateBalance = 0.0
  def deposit(amount: Double) {
    if (amount > 0) privateBalance += amount
  }
  def withdrawal(amount: Double) {
    if (amount > 0) privateBalance -= amount
  }
  def balance = privateBalance
}

val myAccount = new BankAccount
myAccount.deposit(51.99)
println(f"${myAccount.balance}%.2f")
myAccount.deposit(-20)
println(f"${myAccount.balance}%.2f")
myAccount.withdrawal(20)
println(f"${myAccount.balance}%.2f")
myAccount.withdrawal(-20)
println(f"${myAccount.balance}%.2f")
