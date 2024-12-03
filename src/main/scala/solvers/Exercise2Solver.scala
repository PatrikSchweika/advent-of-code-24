package solvers


// I
private case class FoldAcc(isValid: Boolean, increase: Int)

object Exercise2Solver extends Solver {
  private val maxNumberDistance = 3
  private val minNumberDistance = 1

  override def solve(lines: Seq[String]): Int = {
    val numberMatrix = lines.map(line => {
      val numParts = line.split(" +")

      numParts.map(str => str.toInt).toList
    })

    val validLines = numberMatrix.foldLeft(0)((acc, numbers) => {
      val FoldAcc(isLineValid, _) = numbers.sliding(2).foldLeft(FoldAcc(true, 0))((acc, pair) => {
        val FoldAcc(isValid, accIncrease) = acc

        pair match {
          case List(a, b) =>
            val diff = Math.abs(a - b)
            val increase = if (a < b) 1 else -1

            FoldAcc(
              isValid && diff >= minNumberDistance && diff <= maxNumberDistance && (accIncrease == 0 || increase == accIncrease),
              increase
            )
          case List(a) => acc
          case _ => acc
        }
      })

      if (isLineValid) acc + 1 else acc
    })

    validLines
  }
}
