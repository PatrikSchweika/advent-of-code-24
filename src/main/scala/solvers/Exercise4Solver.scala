package solvers

import scala.annotation.tailrec

object Exercise4Solver extends ExerciseSolver:
  private val word = "XMAS"

  private val directions: Seq[(Int, Int)] = List(
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0),
    (1, 1),
    (1, -1),
    (-1, 1),
    (-1, -1),
  )

  private def searchDirections(lines: Seq[String], position: (Int, Int)): Int = {
    val (i, j) = position
    
    if (lines(i)(j) != word(0)) {
      return 0
    }

    directions
      .map((vi, vj) => searchDirectionAux(lines, position = (i + vi, j + vj), direction = (vi, vj), wordIndex = 1))
      .map(isWord => if isWord then 1 else 0)
      .sum
  }

  @tailrec
  private def searchDirectionAux(lines: Seq[String], position: (Int, Int), direction: (Int, Int), wordIndex: Int): Boolean = {
    val (i, j) = position
    val (vi, vj) = direction
    
    if (i < 0 || i >= lines.length) {
      return false
    }
    
    if (j < 0 || j >= lines(i).length) {
      return false
    }
    
    if (lines(i)(j) != word(wordIndex)) {
      return false
    }
    
    if (wordIndex == word.length - 1) {
      return true
    }
    
    searchDirectionAux(
      lines,
      (i + vi, j + vj),
      direction, 
      wordIndex + 1
    )
  }

  override def solve(lines: Seq[String]): Number = {
    var words = 0
    
    for (i <- lines.indices) {
      for (j <- lines(i).indices) {
        words += searchDirections(lines, (i, j))
      }
    }

    words
  }
