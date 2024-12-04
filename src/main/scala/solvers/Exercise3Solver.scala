package solvers

import scala.util.matching.Regex

object Exercise3Solver extends ExerciseSolver:
  val mulPattern: Regex = """mul\(([0-9]{1,3}),([0-9]{1,3})\)""".r

  override def solve(lines: Seq[String]): Int = {
    val str = lines.mkString

    mulPattern.findAllMatchIn(str).foldLeft(0)((sum, m) => {
      m match {
        case mulPattern(a, b) => sum + a.toInt * b.toInt
      }
    })
  }
