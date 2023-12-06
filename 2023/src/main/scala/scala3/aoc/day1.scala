package scala3.aoc

def part1 =
    val source = io.Source.fromResource("input1")
    val input  = source.getLines().toList
    input.map(s => s.filter(_.isDigit)).map(s => s"${s.head}${s.last}".toInt).sum

def part2 =
    val regex = """\d|one|two|three|four|five|six|seven|eight|nine""".r
    val digitsMap = Map(
      "one"   -> 1,
      "two"   -> 2,
      "three" -> 3,
      "four"  -> 4,
      "five"  -> 5,
      "six"   -> 6,
      "seven" -> 7,
      "eight" -> 8,
      "nine"  -> 9
    )
    io.Source
        .fromResource("input1")
        .getLines
        .flatMap: line =>
            val all = Vector.unfold(line): line =>
                for
                    m <- regex.findFirstMatchIn(line)
                    mstr = m.matched
                    mint = digitsMap.getOrElse(mstr, mstr.toInt)
                yield (mint, line.substring(m.start + 1))

            for
                f <- all.headOption
                l <- all.lastOption
            yield f * 10 + l
        .sum

@main def run: Unit =
    println("\nDay 1\n-------------")
    println(s"Part 1: $part1")
    println(s"Part 2: $part2")
