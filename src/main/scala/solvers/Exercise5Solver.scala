package solvers

object Exercise5Solver extends ExerciseSolver:
  private case class OrderingAcc(set: Set[Int], valid: Boolean)

  private def isInCorrectOrder(update: Seq[Int], ordering: Seq[(Int, Int)]): Boolean = {
    val acc = OrderingAcc(Set(), true)

    val result =
      update.foldLeft(acc)((acc, num) =>
        val valid = !ordering.exists((left, right) => {
          num == left && acc.set(right)
        })

        OrderingAcc(
          acc.set + num,
          if !acc.valid then false else valid
        )
      )

    result.valid
  }

  override def solve(lines: Seq[String]): Number = {
    var ordering: Seq[(Int, Int)] = Seq()
    var updates: Seq[Seq[Int]] = Seq()

    for (line <- lines) {
      if (line.contains('|')) {
        val groups = line.split('|')

        ordering = ordering.appended((groups(0).toInt, groups(1).toInt))
      }
      else if (line.contains(',')) {
        val groups = line.split(',')

        updates = updates.appended(
          groups.map(group => group.toInt)
        )
      }
    }

    updates
      .filter(update => isInCorrectOrder(update, ordering))
      .map(update => update(update.length / 2))
      .sum
  }
