class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

object Main extends App {
  val myCreature = new Creature
  println(s"${myCreature.range}")

  val myAnt = new Ant 
  println(s"${myAnt.range}")
}

/*
// When range is val:
haven-macbook:Chapter08 nduhovnijs$ javap -private Creature.class
Compiled from "Ch08Ex09.scala"
public class Creature {
  private final int range;
  private final int[] env;
  public int range();
  public int[] env();
  public Creature();
}

// When range is def:
public class Creature {
  private final int[] env;
  public int range();
  public int[] env();
  public Creature();
}

// Difference is that there's actually no private field when range is def.
// Similar situation when changing in subclass. When it's val - we have 
// private final field (constant). When it's def - we don't:
//
public class Ant extends Creature {
  private final int range;
  public int range();
  public Ant();
}

public class Ant extends Creature {
  public int range();
  public Ant();
} 
*/
