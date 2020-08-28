package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  print(x)

  // x = 2 -> VALS ARE IMMUTABLE

  val x2 = 42

  // COMPILER CAN INFER TYPES

  val aString: String = "hello"
  val anotherString = "goodbye"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 51352468515458452L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects


}
