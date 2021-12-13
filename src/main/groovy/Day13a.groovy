class Day13a {

    static void main(String[] args) {
        Map instructions = prepareData('src/main/resources/input13.txt')
        println(process(instructions))
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

    public static Long process(Map instructions) {
        List points
        def matcher = instructions.folding[0] =~ /fold along (\w)=(\d+)/
        if (matcher[0][1] == 'x') {
            Integer foldingPoint = matcher[0][2] as Integer
            points = instructions.points.collect {
                if (it[0] > foldingPoint) {
                    return [2 * foldingPoint - it[0], it[1]]
                }
                return it
            }
        } else {
            Integer foldingPoint = matcher[0][2] as Integer
            points = instructions.points.collect {
                if (it[1] > foldingPoint) {
                    return [it[0], 2 * foldingPoint - it[1]]
                }
                return it
            }
        }
        return points.unique().size()
    }
}
