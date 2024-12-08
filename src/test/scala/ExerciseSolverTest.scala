import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table
import solvers.ExerciseSolver

import scala.io.Source

class ExerciseSolverTest extends AnyFunSuite {
  private val testCases = Table(
    ("Exercise", "fileName", "expectedResult"),
    (1, "./files/test/exercise-1.txt", 11),
    (2, "./files/test/exercise-2.txt", 2),
    (3, "./files/test/exercise-3.txt", 161),
    (4, "./files/test/exercise-4.txt", 18),
    (5, "./files/test/exercise-5.txt", 143),
  )

  test("Exercise tests") {
    forAll(testCases) { (exercise, fileName, expectedResult) =>
      val solver = ExerciseSolver(exercise)
      val source = Source.fromFile(fileName)
      val lines = source.getLines.toList

      assert(solver.solve(lines) == expectedResult)
    }
  }
}
