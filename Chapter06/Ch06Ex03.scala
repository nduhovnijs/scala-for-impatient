object Origin extends java.awt.Point {
}

object Hello extends App {
  println(s"Coordinates of Origin points are... Let's see what's in toString: ${Origin}")
  Origin.setLocation(13,10)
  println(s"And now location is... Let's see what's in toString: ${Origin}")
}

// why extending java.awt.Point is not such a great idea?
// 1. Objects don't have constructor parameters, and Point has convenient constructors with parameters.
// 2. Maybe because of getters and setters? No, can't find real arguments on why can it be bad.
