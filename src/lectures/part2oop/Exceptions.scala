package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)

//   1. throwing excpetions

//  val WeirdValue = throw new NullPointerException

//   throwable classes extend the Throwable class
//   Exception and Error are the major Throwable subtypes
//
//   2. catching exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    println("finally")
//     optional
//     does not influence the return type oif this expression
//     use finally only for side effects
  }

  println(potentialFail)

//  3. how to define our own exceptions

  class MyException extends Exception

  val exception = new MyException

//  throw exception

//  ---------------------------------


//  OOM
//  val array = Array.ofDim(Int.MaxValue)

//  SO
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = add(x, -y)

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (x == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.subtract(Int.MinValue, 10))
  println(PocketCalculator.divide(2, 0))








}
