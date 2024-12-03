import org.scalatest.funsuite.AnyFunSuite
import solvers.Exercise3Solver

import scala.io.Source

class Exercise3SolverTest extends AnyFunSuite {
  test("Exercise 3 test") {
    val solver = Exercise3Solver

    val source = Source.fromFile("./files/test/exercise-3.txt")
    val lines = source.getLines.toList

    assert(solver.solve(lines) == 161)
  }
}

