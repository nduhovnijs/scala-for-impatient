/* Initial version
class UnitConversion {
}

object InchesToCentimeters extends UnitConversion {
  def convert(sourceValue: Double)  = {
    sourceValue * 2.54
  }
}

object GallonsToLiters extends UnitConversion {
  def convert(sourceValue: Double)  = {
    sourceValue * 3.78541
  }
}

object MilesToKilometers extends UnitConversion {
  def convert(sourceValue: Double)  = {
    sourceValue * 1.60934
  }
}
*/

// Much more elegant solution is seen on https://github.com/hempalex/scala-impatient/blob/master/Chapter06/02.scala
// gonna steal it instead of my original one above.

class UnitConversion(val conversionFactor: Double) {
  def convert(sourceValue: Double) = sourceValue * conversionFactor
}

object InchesToCentimeters extends UnitConversion(2.54) 
object GallonsToLiters extends UnitConversion(3.78541)
object MilesToKilometers extends UnitConversion(1.60934)

object Hello extends App {
  println(s"5.5 inches is ${InchesToCentimeters.convert(5.5)} centimeters")
  println(s"3 gallons is ${GallonsToLiters.convert(3)} liters")
  println(s"60 miles is ${MilesToKilometers.convert(60)} kilometers")
}
