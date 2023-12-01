fun day01() {
    val day = "01"

    fun parseInput() =
        getInputFile(day)
            .readText()
            .trim()
            .split("\n")


    fun a(input: List<String>): Int {
        return input
            .map{ it.filter{it.isDigit()}}
            .sumOf{(it.take(1) + it.takeLast(1)).toInt()}
    }

    fun b(input: List<String>): Int {
        return input
            .map{it
                .replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "f4r")
                .replace("five", "f5e")
                .replace("six", "s6x")
                .replace("seven", "s7n")
                .replace("eight", "e8t")
                .replace("nine", "n9e")
            }
            .map{ it.filter{it.isDigit()}}
            .sumOf{(it.take(1) + it.takeLast(1)).toInt()}
    }

    val resultA = a(parseInput())
    println("Result for a: $resultA")
    val resultB = b(parseInput())
    println("Result for b: $resultB")
}
