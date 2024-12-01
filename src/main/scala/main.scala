import solvers.Solver

import java.nio.file.{Files, Paths}
import scala.io.Source

@main
def main(fileName: String, exercise: Int): Unit =
  if (!Files.exists(Paths.get(fileName))) {
    println(s"File $fileName does not exists")
    return
  }

  val source = Source.fromFile(fileName)
  val lines = source.getLines.toList

  source.close()

  val solver = Solver(exercise)
  val solution = solver.solve(lines)

  println(s"Solution: $solution")

