import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table
import solvers.{Exercise1Solver, Exercise2Solver, Exercise3Solver, Exercise4Solver}

import scala.io.Source

class ExerciseSolverTest extends AnyFunSuite {
  private val testCases = Table(
    ("Solver", "fileName", "expectedResult"),
    (Exercise1Solver, "./files/test/exercise-1.txt", 11),
    (Exercise2Solver, "./files/test/exercise-2.txt", 2),
    (Exercise3Solver, "./files/test/exercise-3.txt", 161),
    (Exercise4Solver, "./files/test/exercise-4.txt", 18),
  )

  test("Exercise tests") {
    forAll(testCases) { (solver, fileName, expectedResult) =>
      val source = Source.fromFile(fileName)
      val lines = source.getLines.toList

      assert(solver.solve(lines) == expectedResult)
    }
  }
}
