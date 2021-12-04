class Day2b {

    static void main(String[] args) {

        List<Map> moves = []
        moves = prepareData('src/main/resources/input2.txt')
        println(process(moves))
    }

    public static List<Map> prepareData(String path) {
        def f = new File(path)
        List<Map<String,Integer>> moves = f.readLines().collect { it.split(' ') }.collect{[(it[0]):it[1].toInteger()]}
        moves
    }

    public static Long process(List moves) {
        def depth = 0
        def horizontal = 0
        def aim = 0
        moves.each { Map<String, Integer> k ->
            String key = k.keySet()[0]
            if (key == 'up') {
                aim -= k[key]
            }
            if (key == 'down') {
                aim += k[key]
            }
            if (key == 'forward') {
                horizontal += k[key]
                depth += aim * k[key]
            }
        }
        return depth * horizontal
    }
}
