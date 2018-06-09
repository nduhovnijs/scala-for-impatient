package com {
  object John {
    var salary = 1000.99

    // this makes method visible only to package com
    private[com] def giveRaise(rate: Double) {
      salary = rate
    }

    // an this one should be visible to other packages
    def giveRaise2(rate: Double) {
      salary = rate
    }
  }

  object JohnsBoss {
    def test {
      println(John.salary)
      John.giveRaise(1200)
      println(John.salary)
    }
  }
}

package net {
  object NotJohnsBoss {
    def test {
      println(com.John.salary)
      // this one will not work because of visibility
      //com.John.giveRaise(1200)
      // this one will work
      com.John.giveRaise2(1300)
      println(com.John.salary)
    }
  }
}

object Hello extends App {
  com.JohnsBoss.test
  net.NotJohnsBoss.test
}
