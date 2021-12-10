class Day10a {

    static final Map points = [')': 3,
                               ']': 57,
                               '}': 1197,
                               '>': 25137]

    static void main(String[] args) {
        List<String> lines = prepareData('src/main/resources/input10.txt')
        println(process(lines))
    }

    public static List prepareData(String path) {
        new File(path).readLines()
    }

    public static Long process(List lines) {
        def illegalCharacters = []
        Map<String, String> pairs = ['(': ')', '[': ']', '{': '}', '<': '>']
        lines.each { line ->
            List processLine = []
            for (String symbol in line) {
                if (symbol in pairs.keySet()) {
                    processLine.push(symbol)
                } else {
                    if (pairs[processLine.pop()] != symbol) {
                        illegalCharacters << symbol
                        break
                    }
                }
            }
        }
        return illegalCharacters.collect{points[it]}.sum()
    }
}
