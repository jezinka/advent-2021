class Day5b {

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
    }

    public static Long process(List<List<Integer>> positions) {
        List points = []
        positions.each { it ->
            if (it[1] == it[3]) {
                (it[0]..it[2]).each { t ->
                    points << "${t},${it[1]}"
                }
            } else if (it[0] == it[2]) {
                (it[1]..it[3]).each { t ->
                    points << "${it[0]},${t}"
                }
            } else {
                def rangex = it[0]..it[2]
                def rangey = it[1]..it[3]

                rangex.size().times { t ->
                    points << "${rangex[t]},${rangey[t]}"
                }
            }
        }
        return points.countBy { it }.findAll { it.value >= 2 }.size()
    }
}
