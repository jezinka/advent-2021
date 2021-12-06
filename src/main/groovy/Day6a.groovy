class Day6a {

    static void main(String[] args) {
        List positions = prepareData('src/main/resources/input6.txt')
        println(process(positions, 80))
    }

    public static List prepareData(String path) {
        new File(path).readLines()[0].split(',').collect { it as Integer }
    }

    public static Long process(List<Integer> positions, Integer days) {
        Map<Integer, Long> lanternfishStages = (0..8).collectEntries { [(it): 0] }

        for (Integer p in positions) {
            lanternfishStages[p] += 1
        }

        days.times {
            Map<Integer, Long> lanternfishStagesClone = (0..8).collectEntries { [(it): 0L] }
            for (k in lanternfishStages.keySet()) {
                if (k != 0) {
                    lanternfishStagesClone[k - 1] += lanternfishStages[k]
                } else {
                    lanternfishStagesClone[6] += lanternfishStages[k]
                    lanternfishStagesClone[8] += lanternfishStages[k]
                }
            }
            lanternfishStages = lanternfishStagesClone.collectEntries { it }
        }
        return lanternfishStages.values().sum() as Long
    }
}
