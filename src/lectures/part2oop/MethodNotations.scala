package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def +(nick: String): Person = new Person(name + " (" + nick + ")", favouriteMovie)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def learns(s: String): String = name + " learns " + s
    def learns(): String = learns("Scala")
    def apply(n: Int): String = name + " watched " + favouriteMovie + " " + n + " times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation = operator notation (syntactic sugar)

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  // Prefix notation:

  val x = -1 // equivalentt with 1.unary_-
  val y = 1.unary_-
  // unary prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learns "Scala")
  println(mary learns)
  println(mary(2))

}
