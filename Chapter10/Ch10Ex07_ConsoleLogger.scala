trait ConsoleLogger {
  def log(msg: String) { println(msg) }
  val loggerName = "ConsoleLogger"
}