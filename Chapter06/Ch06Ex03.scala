object Origin extends java.awt.Point {
}

object Origin2 extends java.awt.Point {
}

object Hello extends App {
  println(s"Coordinates of Origin points are... Let's see what's in toString: ${Origin}")
  Origin.setLocation(13,10)
  println(s"And now location is... Let's see what's in toString: ${Origin}")
  
  println(s"Coordinates of Origin2 points are... Let's see what's in toString: ${Origin2}")
  Origin2.setLocation(12,9)
  println(s"And now location is... Let's see what's in toString: ${Origin2}")

  println(s"And now let's check original one. Let's see what's in toString: ${Origin}")
}

// why extending java.awt.Point is not such a great idea?
// 1. Objects don't have constructor parameters, and Point has convenient constructors with parameters.
// 2. Maybe because of getters and setters? No, can't find real arguments on why can it be bad.
// 3. Also checked that there's no dirty magic allowing only 1 such Origin object to function properly
// (as I was concerned after reading https://stackoverflow.com/questions/21604763/scala-singleton-objects)
// So, tbh I can't name reasons except for 1.
