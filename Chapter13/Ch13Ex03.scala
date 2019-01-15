import scala.collection.mutable.ListBuffer

object Main extends App {
  // "time" function taken from https://biercoff.com/easily-measuring-code-execution-time-in-scala/
  // 1s = 1000'000'000ns
  def time[R](block: => R): R = {
      val t0 = System.nanoTime()
      val result = block    // call-by-name
      val t1 = System.nanoTime()
      println("Elapsed time: " + (t1 - t0) + "ns")
      result
  }

  //val a = time((1 to 1000000).foldLeft(ListBuffer(0))((lb, i) => lb += i))
  // more compact version:
  val a = (1 to 100000).to[ListBuffer]

  // Results are very curious. If order of execution is the following
  //time(a.indices.filter(_ % 2 == 0).foldLeft(ListBuffer[Int]())((l, i) => l += a(i)))
  //time(a.indices.reverse.filter(_ % 2 == 0).map(a.remove(_)))
  // it's
  // Elapsed time: 5757361897ns
  // Elapsed time: 6511021208ns

  // If order is reverse, it's
  //time(a.indices.reverse.filter(_ % 2 == 0).map(a.remove(_)))
  //time(a.indices.filter(_ % 2 == 0).foldLeft(ListBuffer[Int]())((l, i) => l += a(i)))
  //Elapsed time: 5670824048ns
  //Elapsed time: 1627903403ns

  // So, in any case creating new list is faster.
  // However, there seem some weird optimisation to be going on in second case.

  // I'll compare it with leaving out only one option per execution.
  // Results of
  //time(a.indices.reverse.filter(_ % 2 == 0).map(a.remove(_)))
  //Elapsed time: 5517782471ns
  //Elapsed time: 5589321406ns
  //Elapsed time: 6015606239ns

  // Results of
  time(a.indices.filter(_ % 2 == 0).foldLeft(ListBuffer[Int]())((l, i) => l += a(i)))
  //Elapsed time: 5668152291ns
  //Elapsed time: 5636521779ns
  //Elapsed time: 5733769006ns

  //Whoa! Resuls are the same.
  //So, we have different results only when placing two different executions one after one.
  //Probably, some optimisation takes place in second case (like compiler understands that list is same).
  //As for first case - it's probably some GC-ish(?) to run after first operation that slows things down.
}
