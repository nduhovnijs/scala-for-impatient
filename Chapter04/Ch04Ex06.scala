val weekdays = scala.collection.mutable.LinkedHashMap(
  "Monday"    -> java.util.Calendar.MONDAY,
  "Tuesday"   -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday"  -> java.util.Calendar.THURSDAY,
  "Friday"    -> java.util.Calendar.FRIDAY,
  "Saturday"  -> java.util.Calendar.SATURDAY,
  "Sunday"    -> java.util.Calendar.SUNDAY
)

for ((name, order) <- weekdays) println("Day " + name + " is number " + order)
