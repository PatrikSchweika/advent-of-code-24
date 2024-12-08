package solvers

object Exercise6Solver extends ExerciseSolver:
  private def getGuardPosition(lines: Seq[String]): (Int, Int) = {
    val y = lines.indexWhere(line => {
      line.contains('^')
    })

    val x = lines(y).indexOf('^')

    (x, y)
  }
  
  override def solve(lines: Seq[String]): Int = {
    val (x, y) = getGuardPosition(lines)

    0
  }
