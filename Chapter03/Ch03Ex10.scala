val allTimezones = java.util.TimeZone.getAvailableIDs
val americaTimezones = allTimezones.filter((tz: String) => tz.startsWith("America"))
val strippedAmericaTimezones = for (tz <- americaTimezones) yield tz.drop(8)
print(strippedAmericaTimezones.mkString(", "))
