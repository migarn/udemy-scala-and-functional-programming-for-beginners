package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog extends Animal {
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
    override val creatureType: String = "domestic"
  }

  class Duck(override val creatureType: String) extends Animal {
  }

  class Horse(horseType: String) extends Animal {
    override val creatureType: String = horseType
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)
  val duck = new Duck("domestic")
  println(duck.creatureType)
  val horse = new Horse("Big horse")
  println(cat.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in this file, but prevents extentsion in other files


}
