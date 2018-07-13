// I'm grumpy and I don't have favorite book, so just
// implementing example from https://www.geeksforgeeks.org/inheritance-in-java/
class Bicycle(initialGear: Int, initialSpeed: Int) {
    private var _gear = initialGear;
    private var _speed = initialSpeed;
         
    def applyBrake(decrement: Int) { _speed -= decrement }
    def speedUp(increment: Int) { _speed += increment }

    def gear = _gear
    def speed = _speed

    override def toString = s"No of gears are ${gear} \n speed of bicycle is ${speed}"
}
 
// derived class
class MountainBike(initialGear: Int, initialSpeed: Int, startHeight: Int) 
  extends Bicycle (initialGear, initialSpeed) {
    private var _seatHeight = startHeight
 
    def setHeight(newValue: Int) { _seatHeight = newValue } 
  
    def seatHeight = _seatHeight
     
    override def toString() = {
      super.toString() + s"\nseat height is ${seatHeight}"
    }
}
 
object Hello extends App {
  val mb = new MountainBike(3, 100, 25);
  println(mb)
}
