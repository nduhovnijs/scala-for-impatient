object Test {
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): java.time.LocalDate = {
      for(st <- sc.parts)
        if (!(st.isEmpty || st == "-"))
          throw new IllegalArgumentException("String is not deconstructible by '-'")
    
      if(args.length != 3)
        throw new IllegalArgumentException("Number of arguments must match 3")

      java.time.LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
    }
  }

  def main(args: Array[String]) {
    val year = "2018"
    val month = "03"
    val date = "13"

    // correct call
    println(date"$year-$month-$date")

    // wrong number of arguments
    //println(date"$year-$month")

    // not deconstructible by '-'
    println(date"$year $month $date")
  }
}
