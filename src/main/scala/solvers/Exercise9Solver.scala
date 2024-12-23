package solvers

object Exercise9Solver extends ExerciseSolver:
  override def solve(lines: Seq[String]): Number = {
    var disk = lines.head.zipWithIndex.foldLeft(Seq[String]())((acc, zip) => {
      val (char, i) = zip

      val fileIndex = i / 2
      val symbol = if i % 2 == 0 then fileIndex.toString else "."

      val elem = char.asDigit

      acc.appendedAll(Range(0, elem).map(_ => symbol))
    })

    var start = 0
    var end = disk.length - 1

    while (start != end) {
      if (disk(start) != ".") {
        start += 1
      }
      else if (disk(end) == ".") {
        end -= 1
      }
      else if (disk(start) == "." && disk(end) != ".") {
        disk = disk
          .updated(start, disk(end))
          .updated(end, ".")

        start += 1
        end -= 1
      }
    }

    val checksum = disk.zipWithIndex.foldLeft(0.toLong)((acc, tuple) => {
      val (elem, i) = tuple

      val value = if elem == "." then 0 else elem.toLong * i

      acc + value
    })

    checksum
  }
