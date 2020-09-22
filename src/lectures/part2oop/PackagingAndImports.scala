package lectures.part2oop

import playground.{PrinceCharming, Cinderella => Princess}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2016)

  // import the package
  // val princess = new playground.Cinderella // -> fully qualified name
  // val princess = new Cinderella
  val princess = new Princess

  // package objects
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // default imports
  // java.lang
  // scala
  // scala.predef

}
