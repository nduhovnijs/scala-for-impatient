object Main extends App {
  println(
    java.util.TimeZone.getAvailableIDs.groupBy(_.split("/")(0)).map(tz => tz._1 -> tz._2.length).filter(
      region => region._1 == "Europe" ||
      region._1 == "Asia" ||
      region._1 == "America" ||
      region._1 == "Australia" ||
      region._1 == "Africa" ||
      region._1 == "Antarctica")
  )
}
