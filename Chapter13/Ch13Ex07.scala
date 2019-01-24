object Main extends App {
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  (prices zip quantities) map { ((_:Double) * (_:Int)).tupled } foreach (println _)
}
