package com {
  package horstmann {
    object AccessMe {
      var chest = "hi friend"
    }
  }
}

// This would compile - package impatient can access parent's AccessMe object
package com {
  package horstmann {
    package impatient {
      object AccessTester {
        override def toString = AccessMe.chest
      }
    }
  }
}

// This would not compile - chained package don't treat com.horstmann as parent
/*
package com.horstmann.impatient2 {
  object AccessTester {
    override def toString = AccessMe.chest
  }
}
*/

// This would not compile - next.Test searches mutable.ArrayBuffer in parent com.horstmann.collection
/*
package com {
  package horstmann {
    package collection {
      package next { 
        object Test {
          val a = new collection.mutable.ArrayBuffer[String]
        }
      }
    }
  }  
}
*/

// This would not compile - next.Test searches mutable.ArrayBuffer in parent com.horstmann.collection
/*
package com {
  package horstmann {
    package collection {
    }
    package next {
      object Test {
        val a = new collection.mutable.ArrayBuffer[String]
      }
    }
  }
}
*/

// This would compile - next.Test won't treat com.horstmann.collection as collection
package com.horstmann.collection {
    package next {
      object Test {
        val a = new collection.mutable.ArrayBuffer[String]
      }
    }
}

object Hello extends App {
  println(com.horstmann.impatient.AccessTester)
}
