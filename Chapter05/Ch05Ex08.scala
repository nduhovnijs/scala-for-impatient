// For primary constructor minimalist one is chosen.
// It allows to reuse it in auxiliary constructurs. Vice versa is not viable, as it seems.
//
// TODO: private val in constructor exposes internal names of vals.
// It may be a problem if constructors are used with explicit parameter names in changed order.
//
class Car(private val _manufacturer: String, private val _modelName: String) {
  private var _modelYear = -1
  var licensePlate = ""

  def this(_manufacturer: String, _modelName: String, _modelYear: Integer) {
    this(_manufacturer, _modelName)
    this._modelYear = _modelYear
  }

  def this(_manufacturer: String, _modelName: String, licensePlate: String) {
    this(_manufacturer, _modelName)
    this.licensePlate = licensePlate
  }

  def this(_manufacturer: String, _modelName: String, _modelYear: Integer, licensePlate: String) {
    this(_manufacturer, _modelName)
    this._modelYear = _modelYear
    this.licensePlate = licensePlate
  }

  def manufacturer = _manufacturer
  def modelName = _modelName
  def modelYear = _modelYear
}

val corolla = new Car("Toyota", "Corolla", 1992, "AB-1992")
println(s"${corolla.manufacturer} ${corolla.modelName} ${corolla.modelYear} ${corolla.licensePlate}")

val prius = new Car(_modelName="Prius", _manufacturer="Corolla")
println(s"${prius.manufacturer} ${prius.modelName} ${prius.modelYear} ${prius.licensePlate}")
