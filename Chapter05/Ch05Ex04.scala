class Time() {
  private var _mins_since_midnight = 0

  def this(h: Int, m: Int) {
    this()
    hours = h
    minutes = m
  }

  def before(other: Time) = {
    _mins_since_midnight < (other.hours * 60 + other.minutes)
  }

  def hours = _mins_since_midnight / 60 
  def minutes = _mins_since_midnight % 60

  def hours_=(h: Int) {
    if (h >= 0 && h <= 23)  
      _mins_since_midnight += h*60
    else
      _mins_since_midnight = _mins_since_midnight % 60
  }

  def minutes_=(m: Int) {
    if (m >= 0 && m <= 59) 
      _mins_since_midnight += m
    else
      _mins_since_midnight = _mins_since_midnight / 60 * 60 
  }
}

var myTime = new Time(15, 30)
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d")
myTime.hours = -5
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d")
myTime.hours = 15
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d")
myTime.minutes = 66
println(f"Time is ${myTime.hours}%2d:${myTime.minutes}%2d\n")

myTime = new Time(15, 30)
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
