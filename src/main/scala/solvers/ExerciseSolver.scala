package solvers

trait ExerciseSolver {
  def solve(lines: Seq[String]): Number
}

object ExerciseSolver {

  def apply(exercise: Int): ExerciseSolver = {
    exercise match
      case 1 => Exercise1Solver
      case 2 => Exercise2Solver
      case 3 => Exercise3Solver
      case 4 => Exercise4Solver
      case 5 => Exercise5Solver
      case 6 => Exercise6Solver
      case 7 => Exercise7Solver
      case 9 => Exercise9Solver
      case _ => throw new IllegalArgumentException(s"Solver for exercise $exercise does not exists")
  }
}