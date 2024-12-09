package solvers

import scala.annotation.tailrec

object Exercise6Solver extends ExerciseSolver:
  private case class Point(x: Int, y: Int)

  private def getGuardPosition(lines: Seq[String]): Point = {
    val y = lines.indexWhere(line => {
      line.contains('^')
    })

    val x = lines(y).indexOf('^')

    Point(x, y)
  }

  @tailrec
  private def getDistinctPositions(lines: Seq[String], position: Point, direction: Point, distinctPositions: Set[Point]): Set[Point] = {
    val nextPosition = Point(position.x + direction.x, position.y + direction.y)

    if (nextPosition.y < 0 || nextPosition.y >= lines.length || nextPosition.x < 0 || nextPosition.x >= lines.head.length) {
      distinctPositions
    }
    else if (lines(nextPosition.y)(nextPosition.x) == '#') {
      val rotatedDirection = Point(-direction.y, direction.x)

      getDistinctPositions(lines, position, rotatedDirection, distinctPositions)
    }
    else {
      getDistinctPositions(lines, nextPosition, direction, distinctPositions + nextPosition)
    }
  }

  override def solve(lines: Seq[String]): Number = {
    val position = getGuardPosition(lines)
    val direction = Point(0, -1)

    val distinctPositions = getDistinctPositions(lines, position, direction, distinctPositions = Set(position))

    distinctPositions.size
  }
