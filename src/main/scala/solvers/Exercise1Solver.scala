package solvers

import scala.collection.mutable

object Exercise1Solver extends Solver {
  override def solve(lines: Seq[String]): Int = {
    val leftNumbers = mutable.PriorityQueue[Int]()
    val rightNumbers = mutable.PriorityQueue[Int]()

    for (line <- lines) {
      val nums = line.split(" +")

      leftNumbers.addOne(nums(0).toInt)
      rightNumbers.addOne(nums(1).toInt)
    }

    val sortedLeft = leftNumbers.dequeueAll
    val sortedRight = rightNumbers.dequeueAll

    sortedLeft
      .zip(sortedRight)
      .map((left, right) => math.abs(left - right))
      .sum()
  }
}
  
