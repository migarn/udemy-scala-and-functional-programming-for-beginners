package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I need first factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
     factHelper(9, 10 * 1)
     factHelper(8, 10 * 9 * 1)
     factHelper(7, 10 * 9 * 8 * 1)
     factHelper(6, 10 * 9 * 8 * 7 * 1)
     factHelper(5, 10 * 9 * 8 * 7 * 6 * 1)
     factHelper(4, 10 * 9 * 8 * 7 * 6 * 5 * 1)
     factHelper(3, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 1)
     factHelper(2, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 1)
     factHelper(1, 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1)
     10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
   */

  print(anotherFactorial(5000))

}
