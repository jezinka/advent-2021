class Day13b {

    static void main(String[] args) {
        Map instructions = prepareData('src/main/resources/input13.txt')
        List<List> points = process(instructions)
        for (int j = 0; j < points*.last().max() + 1; j++) {
            for (int i = 0; i < points*.first().max() + 1; i++) {
                if (points.find { it[0] == i && it[1] == j }) {
                    print('#')
                } else {
                    print(' ')
                }
            }
            println()
        }
    }

    public static Map prepareData(String path) {
        List<String> l = new File(path).readLines()
        List<List<Integer>> points = []
        List<String> foldingInstructions = []
        for (line in l) {
            if (line.startsWith('fold')) {
                foldingInstructions << line
            } else if (line.matches(/\d+,\d+/)) {
                points << line.split(',').collect { it as Integer }
            }
        }
        return [points: points, folding: foldingInstructions]
    }

    public static List process(Map instructions) {
        List points = instructions.points.collect { it }

        instructions.folding.each { folding ->
            def matcher = folding =~ /fold along (\w)=(\d+)/
            if (matcher[0][1] == 'x') {
                Integer foldingPoint = matcher[0][2] as Integer
                points = points.collect {
                    if (it[0] > foldingPoint) {
                        return [2 * foldingPoint - it[0], it[1]]
                    }
                    return it
                }.unique()
            } else {
                Integer foldingPoint = matcher[0][2] as Integer
                points = points.collect {
                    if (it[1] > foldingPoint) {
                        return [it[0], 2 * foldingPoint - it[1]]
                    }
                    return it
                }.unique()
            }
        }
        return points
    }
}
