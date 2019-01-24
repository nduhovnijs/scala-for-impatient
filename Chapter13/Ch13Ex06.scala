// Given a list of integers lst, what is (lst :\ List[Int]())(_ :: _)? (List[Int]() /: lst)(_ :+ _)?
// How can you modify one of them to reverse the list?
object Main extends App {
  val lst = (1 to 4).toList

  // 1) What is "(lst :\ List[Int]())(_ :: _)" ?
  //    ":\" is foldRight. So, statement is equiualent of
  //    lst.foldRight(List[Int]())(_ :: _)
  //    "::" prepends element on the left to list.
  //    So, operation does (1 :: (2 :: (3 :: (4 :: ())))) -
  //      basically makes same list.
  //    (yes, with foldRight starting element is on the right!)

  // 2) What is (List[Int]() /: lst)(_ :+ _)
  //    "/:" is foldLeft. So, statement is equiualent of
  //    lst.foldLeft(List[Int]())(_ :+ _)
  //    ":+" appends element on the left to list.
  //    So, operation does () :+ 1 :+ 2 :+ 3 :+ 4
  //      basically, makes same list (as well as first one).

  // How to modify one of them to reserve the list?
  // option a:
  (lst :\ List[Int]())((coll, elem) => elem :+ coll)

  // option b:
  (List[Int]() /: lst)((coll, elem) => elem +: coll)
}
