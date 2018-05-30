package com.horstmann.impatient {
  object Test {
    val a = 5
  }
}

package nduhovnijs {
  package com {
  }
  object Tester {
    // The following won't compile!
    //override def toString = com.horstmann.impatient.Test.a.toString

    // Have to use _root_ construction to fix that
    override def toString = _root_.com.horstmann.impatient.Test.a.toString
  }
}

object Hello extends App {
  println(nduhovnijs.Tester)
}
