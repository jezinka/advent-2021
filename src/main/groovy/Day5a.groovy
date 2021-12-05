class Day5a {

    static void main(String[] args) {
        List positions = prepareData('src/main/resources/input5.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        def f = new File(path)
        return f.readLines()
                .collect {
                    it.split(' -> ')
                            .collect { it.split(',').collect { it as Integer } }
                            .flatten()
                }
                .findAll { it[0] == it[2] || it[1] == it[3] }
    }

    public static Long process(List<List<Integer>> positions) {
        List points = []
        positions.each { it ->
            if (it[1] == it[3]) {
                def minx = [it[2], it[0]].min()
                def maxx = [it[2], it[0]].max()
                for (int i = minx; i <= maxx; i++) {
                    points << "${i},${it[1]}"
                }
            } else {
                def miny = [it[1], it[3]].min()
                def maxy = [it[1], it[3]].max()
                for (int i = miny; i <= maxy; i++) {
                    points << "${it[0]},${i}"
                }
            }
            println()
        }
        return points.countBy { it }.findAll { it.value >= 2 }.size()
    }
}
