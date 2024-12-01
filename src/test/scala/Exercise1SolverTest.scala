import org.scalatest.funsuite.AnyFunSuite
import solvers.Exercise1Solver

import scala.io.Source

class Exercise1SolverTest extends AnyFunSuite {
  
  
  test("Exercise 1 test file") {
    val solver = Exercise1Solver

    val source = Source.fromFile("./files/test/exercise-1.txt")
    val lines = source.getLines.toList
    
    assert(solver.solve(lines) == 11)
  }
}
