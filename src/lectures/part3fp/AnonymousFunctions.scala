package lectures.part3fp

object AnonymousFunctions extends App {

  val doubler = (x: Int) => x * 2
//  val doubler: Int => Int = x => x * 2
  println(doubler(8))

  // multiple parameters in a lambda:

  val adder = (a: Int, b: Int) => a + b
//  val adder: (Int, Int) => Int = (a, b) => a + b
  println(adder(6,8))

  // no parameters
  val justDoSomething = () => 3
//  val justDoSomething: () => Int = () => 3
  // careful
  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  println(niceIncrementer(5))
  val niceAdder: (Int, Int) => Int = _ + _
  println(niceAdder(100,200))

//  val supperAdder: Int => Int => Int = x => y => x + y
  val supperAdder = (x: Int) => (y: Int) => x + y
  println(supperAdder(3)(4))

}
