class Day6b {

    static void main(String[] args) {
        List positions = Day6a.prepareData('src/main/resources/input6.txt')
        println(Day6a.process(positions, 256))
    }
}
