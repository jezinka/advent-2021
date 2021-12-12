class Day12a {

    static void main(String[] args) {
        List<List<String>> connections = prepareData('src/main/resources/input12.txt')
        println(process(connections))
    }

    public static List<List<String>> prepareData(String path) {
        new File(path).readLines().collect { it.tokenize('-') }
    }

    public static Long process(List<List<String>> connections) {
        List<List<String>> routes = [['start']]

        boolean wasChange = true

        List newPaths = []

        while (wasChange) {
            wasChange = false
            routes.addAll(newPaths)
            newPaths.clear()
            for (int i = 0; i < routes.size(); i++) {
                List<String> path = routes[i]
                if (path.last() == 'end') {
                    continue
                }
                List<String> candidates = findCandidate(connections, path.last())
                List toVisit = candidates.findAll { !isSmallCave(it) || (isSmallCave(it) && !(it in path)) }.unique()

                if (toVisit) {
                    wasChange = true
                    toVisit.eachWithIndex { String entry, int j ->
                        if (j != 0) {
                            List newPath = path.collect { it }
                            newPath.add(entry)
                            newPaths.add(newPath)
                        }
                    }
                    routes[i].add(toVisit[0])
                }
            }
        }
        return routes.findAll { it.first() == 'start' && it.last() == 'end' }.size()
    }

    public static List<String> findCandidate(List<List<String>> connections, String hereIAm) {
        Set<String> possibleEntries = []
        possibleEntries.addAll(connections.findAll { it[0] == hereIAm }*.last())
        possibleEntries.addAll(connections.findAll { it[1] == hereIAm }*.first())
        possibleEntries.toList()
    }

    private static boolean isSmallCave(String cave) {
        return cave.toLowerCase() == cave
    }
}
