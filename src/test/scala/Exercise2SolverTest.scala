import org.scalatest.funsuite.AnyFunSuite
import solvers.Exercise2Solver
import scala.io.Source

class Exercise2SolverTest extends AnyFunSuite {
  test("Exercise 2 test") {
    val solver = Exercise2Solver

    val source = Source.fromFile("./files/test/exercise-2.txt")
    val lines = source.getLines.toList

    assert(solver.solve(lines) == 2)
  }
}

