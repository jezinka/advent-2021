class Day9b {

    static void main(String[] args) {
        List<String> positions = prepareData('src/main/resources/input9.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        new File(path).readLines().collect { it.split('').collect { it as Integer } }
    }

    public static Long process(List<List<Integer>> positions) {
        List<String> lowPoints = []
        for (int i = 0; i < positions.size(); i++) {
            for (int j = 0; j < positions[i].size(); j++) {
                ArrayList neighbours = Day9a.getNeighbours(i, j, positions)
                if (neighbours.min() > positions[i][j]) {
                    lowPoints << "$i-$j".toString()
                }
            }
        }

        Map<String, List<String>> mapBasin = [:]

        lowPoints.each { lowPoint ->
            Set<String> basin = [lowPoint]
            boolean somethingNew = true
            while (somethingNew) {
                int basinSize = basin.size()

                def tempBasin = []
                basin.each { b ->
                    def points = b.split('-').collect { it as Integer }
                    def i = points[0]
                    def j = points[1]

                    if (i > 0 && positions[i - 1][j] != 9) {
                        tempBasin << "${i - 1}-$j".toString()
                    }
                    if (i < positions.size() - 1 && positions[i + 1][j] != 9) {
                        tempBasin << "${i + 1}-$j".toString()
                    }
                    if (j > 0 && positions[i][j - 1] != 9) {
                        tempBasin << "$i-${j - 1}".toString()
                    }
                    if (j < positions[i].size() - 1 && positions[i][j + 1] != 9) {
                        tempBasin << "$i-${j + 1}".toString()
                    }
                }
                basin.addAll(tempBasin)
                somethingNew = basin.size() != basinSize
            }
            mapBasin[lowPoint] = basin.collect { it }
        }
        Long result = 1
        mapBasin.sort { -it.value.size() }
                .collect { it.value.size() }[0..2]
                .each {
                    result *= it
                }
        return result
    }
}
