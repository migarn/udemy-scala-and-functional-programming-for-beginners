package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seqs
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val aRange2: Seq[Int] = 1 until 10
  aRange2.foreach(println)

  (1 to 10).foreach(x => println("Hello"))
  (1 to 10).foreach(x => println("Hello " + x))

  // Lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  println(prepended)
  val prependedAppended = 42 +: aList :+ 89
  println(prependedAppended)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)

  val threeElements2 = Array.ofDim[String](3)
  threeElements2.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numberSeq: Seq[Int] = numbers // implicit conversion
  println(numberSeq)

  // vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  // keeps reference to tail
  // updating an element in the middle takes long time
  val numbersList = (1 to maxCapacity).toList

  // depth pf the tree is small
  // needs to replace an entire 32 element chunk
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
