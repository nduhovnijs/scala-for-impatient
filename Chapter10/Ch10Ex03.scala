/*
Original formulation of excercise looks very brutal. 
Either I don't understand value of making diagram and linearisation of SUCH a big hierarchy, or hierarchy has grown from the moment when book was written.
Or author was just in a bad misantropic mood.
I'll shorten excercise to drawing diagram and making linearisation of scala.collection.TraversableLike and hope that I didn't miss same grand plan of initial formulation.

Diagram:
trait TraversableLike[]
  trait HasNewBuilder[]
    abstract class Any
  trait FilterMonadic[]
    abstract class Any
  trait TraversableOnce[]
    trait GenTraversableOnce[]
      abstract class Any
  trait GenTraversableLike
    trait GenTraversableOnce[]
      abstract class Any
    trait Parallelizable[]
      abstract class Any
  trait Parallelizable[]
    abstract class Any

Order of construction
1) Any
2) HasNewBuilder
3) FilterMonadic
4) GenTraversableOnce
5) TraversableOnce
6) Parallelizable
7) GenTraversableLike
8) TraversableLike

Linearization:
lin(TraversableLike) = TraversableLike >> GenTraversableLike >> Parrallelizable >> TraversableOnce >> GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> Any
*/
