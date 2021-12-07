class Day7a {

    static void main(String[] args) {
        List positions = prepareData('src/main/resources/input7.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        new File(path).readLines()[0].split(',').collect { it as Integer }
    }

    public static Long process(List<Integer> positions) {
        int minFuel = Integer.MAX_VALUE
        for (int i = positions.min(); i <= positions.max(); i++) {
            int sumFuel = positions.collect { Math.abs(i - it) }.sum()
            if (sumFuel < minFuel) {
                minFuel = sumFuel
            }
        }
        return minFuel
    }
}
