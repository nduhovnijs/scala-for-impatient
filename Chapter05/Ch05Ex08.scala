// Actually, if primary constructor is used with default parameters,
// no auxiliary constructors are needed at all. 
// Ok, maybe for convenience (for not specifying parameters explicitly), we can add one
// auxiliary - for case when modelYear is not specified, but licensePlate is.
class Car(val manufacturer: String, val modelName: String, val modelYear: Integer = -1, var licensePlate: String = "") {
  def this(manufacturerArg: String, modelNameArg: String, licensePlateArg: String) {
    this(manufacturerArg, modelNameArg, licensePlate=licensePlateArg)
  }

  // toString() was picked when comparing excercise solutions to some other solution on GitHub.
  // Probably, it's properly addressed later in book. Will use now to print conveniently :) 
  override def toString = s"${manufacturer} ${modelName} ${modelYear} ${licensePlate}"
}

val corolla = new Car("Toyota", "Corolla", 1992, "AB-1992")
//println(s"${corolla.manufacturer} ${corolla.modelName} ${corolla.modelYear} ${corolla.licensePlate}")
println(corolla)

val prius = new Car("Toyota", "Prius")
println(prius)

val aveo = new Car("Chevrolet", "Aveo", 2008)
println(aveo)

val insignia = new Car("Opel", "Insignia", "AC-2012")
println(insignia)
