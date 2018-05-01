// For primary constructor initially minimalist one is chosen.
// It allows to reuse it in auxiliary constructurs.
//
// However, actually supplying 4 constructors is not necessary at all.
// It's enough to have 1 with default values. 
//
// TODO: put all the tests, remake to single-primary constructor
// Refresh knowledge of field usage in metod, pick toString (picked from other guys on GitHub)
class Car(val manufacturer: String, val modelName: String) {
  val modelYear = -1
  var licensePlate = ""

  def this(manufacturer: String, modelName: String, modelYear: Integer) {
    this(manufacturer, modelName)
    this.modelYear = _modelYear
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName)
    this.licensePlate = licensePlate
  }

  def this(manufacturer: String, modelName: String, modelYear: Integer, licensePlate: String) {
    this(manufacturer, modelName)
    this.modelYear = modelYear
    this.licensePlate = licensePlate
  }
}

val corolla = new Car("Toyota", "Corolla", 1992, "AB-1992")
println(s"${corolla.manufacturer} ${corolla.modelName} ${corolla.modelYear} ${corolla.licensePlate}")

val prius = new Car(modelName="Prius", manufacturer="Corolla")
println(s"${prius.manufacturer} ${prius.modelName} ${prius.modelYear} ${prius.licensePlate}")
