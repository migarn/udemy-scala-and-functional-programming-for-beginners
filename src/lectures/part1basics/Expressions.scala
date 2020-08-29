package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - ^ / & | ^ << >> >>>>

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // += -+ *= /=
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // ^ NEVER WRITE THIS AGAIN

  // EVERYTHING in Scala is an expression!

  val aWeirdValue = (aVariable = 3) // Unit ==== void
  println(aWeirdValue)

  // side effects: println(), whiles, reasigning

  // Code blocks:

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "goodbye"
  }

  println(aCodeBlock)

  // 1. Difference between "hello world" vs println("helloworld")

  println("hello world")
  println(println("hello world"))

  // 2

  val someValue = {
    2 < 3
  }

  println(someValue)

  // 3

  val someOtherValue = {
    if (someValue) 239 else 98
    42
  }

  println(someOtherValue)

}
