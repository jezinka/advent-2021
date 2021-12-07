class Day7b {

    static void main(String[] args) {
        List positions = prepareData('src/main/resources/input7.txt')
        println(process(positions))
    }

    public static List prepareData(String path) {
        new File(path).readLines()[0].split(',').collect { it as Integer }
    }

    public static Long process(List<Integer> positions) {
        int minFuel = Integer.MAX_VALUE
        Long[] fuel = new Long[positions.max() + 1]
        fuel[0] = 0
        fuel[1] = 1
        for (int i = positions.min(); i <= positions.max(); i++) {
            int sumFuel = positions.collect {
                findFuel(Math.abs(i - it), fuel)
            }.sum()
            if (sumFuel < minFuel) {
                minFuel = sumFuel
            }
        }
        return minFuel
    }

    public static Long findFuel(int steps, Long[] fuel) {
        if (fuel[steps] != null) {
            return fuel[steps]
        } else {
            return fuel[steps] = findFuel(steps - 1, fuel) + steps
        }
    }
}
