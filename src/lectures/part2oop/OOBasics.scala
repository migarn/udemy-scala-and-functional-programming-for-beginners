package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))
  println(person.greet())

}

// constructor
class Person(name: String, val age: Int)  {
  val x = 2 // vals or vars inside the class are class fields
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name")

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameters are not fields
