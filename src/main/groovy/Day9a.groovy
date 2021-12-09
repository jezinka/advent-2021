class Day9a {

    static void main(String[] args) {
        List<String> positions = prepareData('src/main/resources/input9.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        new File(path).readLines().collect { it.split('').collect { it as Integer } }
    }

    public static Long process(List<List<Integer>> positions) {
        def lowPoints = []
        for (int i = 0; i < positions.size(); i++) {
            for (int j = 0; j < positions[i].size(); j++) {
                ArrayList neighbours = getNeighbours(i, j, positions)
                if (neighbours.min() > positions[i][j]) {
                    lowPoints << positions[i][j]
                }
            }
        }
        return lowPoints.collect { it + 1 }.sum()
    }

    public static ArrayList getNeighbours(int i, int j, List<List<Integer>> positions) {
        def neighbours = []
        if (i > 0) neighbours << positions[i - 1][j]
        if (i < positions.size() - 1) neighbours << positions[i + 1][j]
        if (j > 0) neighbours << positions[i][j - 1]
        if (j < positions[i].size() - 1) neighbours << positions[i][j + 1]
        neighbours
    }
}
