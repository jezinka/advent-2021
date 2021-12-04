class Day3a {

    static void main(String[] args) {
        List<List> bits = prepareData('src/main/resources/input3.txt')
        println(process(bits))
    }

    public static List prepareData(String path) {
        def f = new File(path)
        List data = f.readLines().collect { it.split('') }
        data
    }

    public static Long process(List<List> bits) {
        def gamma = ''
        def epsilon = ''
        for (int i = 0; i < bits.first().size(); i++) {
            gamma += bits*.getAt(i).countBy { it }.max { it.value }.key
            epsilon += bits*.getAt(i).countBy { it }.min { it.value }.key
        }
        Long.parseLong(gamma, 2) * Long.parseLong(epsilon, 2)

    }
}
