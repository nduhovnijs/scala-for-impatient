object Conversions {
  def inchesToCentimeters(inches: Double) = inches * 2.54
  def gallonsToLiters(gallons: Double) = gallons * 3.78541
  def milesToKilometers(miles: Double) = miles * 1.60934
}

object Hello extends App {
  println(s"5.5 inches is ${Conversions.inchesToCentimeters(5.5)} centimeters")
  println(s"3 gallons is ${Conversions.gallonsToLiters(3)} liters")
  println(s"60 miles is ${Conversions.milesToKilometers(60)} kilometers")
}
