class Day8a {

    static void main(String[] args) {
        List<String> positions = prepareData('src/main/resources/input8.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        new File(path).readLines().collect { it.split(/ \| /)[1].split(' ') }.flatten()
    }

    public static Long process(List<String> positions) {
        positions.count { it.size() == 2 || it.size() == 3 || it.size() == 4 || it.size() == 7 }
    }
}
