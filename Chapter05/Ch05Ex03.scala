class Time() {
  private var _hours = 0
  private var _minutes = 0

  def this(h: Int, m: Int) {
    this()
    hours = h
    minutes = m
  }

  def before(other: Time) = (_hours * 60 + _minutes) < (other.hours * 60 + other.minutes)

  def hours = _hours
  def minutes = _minutes

  def hours_=(h: Int) {
    if (h < 0 || h > 23) _hours = 0
    else _hours = h
  }

  def minutes_=(m: Int) {
    if (m < 0 || m > 59) _minutes = 0
    else _minutes = m
  }
}

var myTime = new Time(15, 30)
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d")
println(f"Is it earlier than 16:30? ${myTime.before(new Time(16, 30))}!")
println(f"Is it earlier than 14:30? ${myTime.before(new Time(14, 30))}!")
println(f"Is it earlier than 15:31? ${myTime.before(new Time(15, 31))}!")
println(f"Is it earlier than 15:29? ${myTime.before(new Time(15, 29))}!\n")

myTime.hours = -5
myTime.minutes = 66
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d")
println(f"Is it earlier than 16:30? ${myTime.before(new Time(16, 30))}!")
println(f"Is it earlier than 14:30? ${myTime.before(new Time(14, 30))}!")
println(f"Is it earlier than 15:31? ${myTime.before(new Time(15, 31))}!")
println(f"Is it earlier than 15:29? ${myTime.before(new Time(15, 29))}!")
