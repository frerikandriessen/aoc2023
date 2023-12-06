fun day06() {
    val day = "06"

    fun parseInput() =
        getInputFile(day)
            .readText()
            .trim()
            .split("\n")

    fun totalDistance(turnsPressed: Long, totalTurns: Long): Long {
        return turnsPressed * (totalTurns - turnsPressed)
    }

    fun a(input: List<String>): Int {
        val times = input[0].split("\\s+".toRegex()).drop(1).map{it.toInt()}
        val recordDistances = input[1].split("\\s+".toRegex()).drop(1).map{it.toInt()}

        var total = 1

        times.forEachIndexed { index, time ->
            var possibleWaysToBeFaster = 0
            val recordDistance = recordDistances[index]

            IntRange(1, time).map {
                if (totalDistance(it.toLong(), time.toLong()) > recordDistance) {
                    possibleWaysToBeFaster++
                }
            }
            total *= possibleWaysToBeFaster
        }

        return total
    }

    fun b(input: List<String>): Long {
        val time = input[0].split("\\s+".toRegex()).drop(1).joinToString("").toLong()
        val recordDistance = input[1].split("\\s+".toRegex()).drop(1).joinToString("").toLong()

        var possibleWaysToBeFaster = 0L

        LongRange(1, time).forEach {
            if (totalDistance(it, time) > recordDistance) {
                possibleWaysToBeFaster++
            }
        }

        return possibleWaysToBeFaster
    }

    val resultA = a(parseInput())
    println("Result for a: $resultA")
    val resultB = b(parseInput())
    println("Result for b: $resultB")
}
