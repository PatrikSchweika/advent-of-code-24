package solvers

object Exercise7Solver extends ExerciseSolver:
  private case class Equation(result: Long, operands: Seq[Long])

  private def isEquationValid(equation: Equation): Boolean =
    isEquationValidAux(equation.result, equation.operands, 0)

  private def isEquationValidAux(expectedResult: Long, operands: Seq[Long], acc: Long): Boolean =
    operands match
      case head +: tail =>
        isEquationValidAux(expectedResult, tail, acc + head) || isEquationValidAux(expectedResult, tail, acc * head)
      case Nil => acc == expectedResult


  override def solve(lines: Seq[String]): Number = {
    val equations = lines
      .map(line => {
        val parts = line.split(":")

        val result = parts(0).toLong
        val operands = parts(1).trim.split(" ").map(_.toLong)

        Equation(result, operands)
      })

    equations
      .filter(isEquationValid)
      .map(_.result)
      .sum
  }
