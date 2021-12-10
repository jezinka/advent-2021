class Day10b {

    static final Map points = [')': 1,
                               ']': 2,
                               '}': 3,
                               '>': 4]

    static void main(String[] args) {
        List<String> lines = prepareData('src/main/resources/input10.txt')

        def result = process(lines)
        assert result != 394050544
        println(result)
    }

    public static List prepareData(String path) {
        new File(path).readLines()
    }

    public static Long process(List lines) {
        def allResults = []
        boolean correct
        Map<String, String> pairs = ['(': ')', '[': ']', '{': '}', '<': '>']
        lines.each { line ->
            correct = true
            List processLine = []
            for (String symbol in line) {
                if (symbol in pairs.keySet()) {
                    processLine.push(symbol)
                } else {
                    if (pairs[processLine.pop()] != symbol) {
                        correct = false
                        break
                    }
                }
            }

            if (correct) {
                Long result = 0
                while (processLine) {
                    String c = pairs[processLine.pop()]
                    print(c)
                    result = 5 * result + points[c]
                }
                println()

                allResults << result
            }
        }
        return allResults.sort()[(Math.ceil(allResults.size() / 2) - 1)]
    }
}
