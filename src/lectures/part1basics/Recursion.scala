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
      else factHelper(x - 1, x * accumulator) // tail recursion
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

  //print(anotherFactorial(5000))

  // when you need loops, use tail recursion

  def concatenateString(aString: String, n: Int): String = {
    def concatenateHelper(aString: String, actualResult: String, n: Int): String = {
      if (n == 1) actualResult
      else concatenateHelper(aString, actualResult + aString, n - 1)
    }
    concatenateHelper(aString, aString, n)
  }

  println(concatenateString("hello",4))
  println(concatenateString("one hello",1))

  def isPrime(n: Int): Boolean = {
    def isPrime(n: Int, divisor: Int, divisors: Int): Boolean = {
      if (divisors == 2) false
      else {
        if (divisor > n/2) true
        else {
          if (n % divisor == 0) isPrime(n, divisor + 1, divisors + 1)
          else isPrime(n, divisor + 1, divisors)
        }
      }
    }
    isPrime(n, 1, 0)
  }

  println(isPrime(3))
  println(isPrime(5))
  println(isPrime(6))
  println(isPrime(7))
  println(isPrime(13))
  println(isPrime(15))
  println(isPrime(83))
  println(isPrime(84))

  def fibonacci(n : Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def fibonacci2(n: Int): Int = {
    def fibonacciHelper(n: Int, actual1: Int, actual2: Int): Int = {
      if (n < 2) actual1 + actual2
      else fibonacciHelper(n - 1, actual2, actual1 + actual2)
    }
    fibonacciHelper(n - 1, 0, 1)
  }

  println(fibonacci(9))
  println(fibonacci2(9))
  println(fibonacci(4))
  println(fibonacci2(4))
  println(fibonacci(15))
  println(fibonacci2(15))





}
