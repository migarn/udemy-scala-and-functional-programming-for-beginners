package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you nees loops, use recursion

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  aFunctionWithSideEffects("hello")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(100))

  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greeting("Madzia",12))

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(3))
  println(factorial(10))

  def fibonacci(n : Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(9))

  def isPrime(n: Int): Boolean = {
    def isPrime(n: Int, divisor: Int, divisors: Int): Boolean = {
      if (divisors == 3) false
      else {
        if (divisor > n) true
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


}
