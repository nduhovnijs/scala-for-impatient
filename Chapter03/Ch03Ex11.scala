import java.awt.datatransfer._
import collection.JavaConverters._
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val natives = flavors.getNativesForFlavor(DataFlavor.imageFlavor).asScala
println(natives.mkString(", "))
