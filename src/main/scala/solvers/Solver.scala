package solvers

trait Solver {
  def solve(lines: Seq[String]): Int
}

object Solver {

  def apply(exercise: Int): Solver = {
    exercise match
      case 1 => Exercise1Solver
      case _ => throw new IllegalArgumentException(s"Solver for exercise $exercise does not exists")
  }
}