// Both Component and Container are classes.
// Design cannot be executed in Java because that would be multiple inheritance.

// With existing implementation we technically can do the following 
// (but this is ugly, since it's illogical order of inheritance).
trait MyComponent extends java.awt.Component {}
trait MyJComponent extends java.awt.Container with MyComponent {}

// We can't do the following - 
//trait MyContainer extends java.awt.Container {}
//class MyJComponent extends java.awt.Component with MyContainer {}
/*
Ch10Ex06.scala:11: error: illegal inheritance; superclass Component
 is not a subclass of the superclass Container
 of the mixin trait MyContainer
class MyJComponent extends java.awt.Component with MyContainer {}
*/

// It seem to be due to inheritance that classes already have (Container -> Component).
// If we'd implement it from scratch, it would be fine:
class Comp {}
trait Cont extends Comp {}
class JComp extends Comp with Cont {}

// Proof that situation with AWT above is due to already existing inheritance:
/*
class Comp {}
class Cont extends Comp {}
trait MyCont extends Cont {}
class JComp2 extends Comp with MyCont {}
*/
/*
Ch10Ex06.scala:29: error: illegal inheritance; superclass Comp
 is not a subclass of the superclass Cont
 of the mixin trait MyCont
class JComp2 extends Comp with MyCont {}
*/

// Swing designers would not touch AWT classes anyway, so this would not fly.

// As it goes to myJContainer, ugly implementation before 
// would allow for cleaner implementation here:
class MyJContainer extends java.awt.Container with MyJComponent {}

// This is valid, because MyJComponent's superclass is java.awt.Container already.