class Day3b {

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
        List bitsForOxygen = bits.collect { it }
        List bitsForCarbonDioxide = bits.collect { it }
        int i = 0
        int j = 0

        while (bitsForOxygen.size() > 1) {
            if (bitsForOxygen*.getAt(i).countBy { it }.values().flatten().unique().size() == 1) {
                bitsForOxygen = bitsForOxygen.findAll { it[i] == '1' }
            } else {
                def firstBit = bitsForOxygen*.getAt(i).countBy { it }.max { it.value }.key
                bitsForOxygen = bitsForOxygen.findAll { it[i] == firstBit }
            }
            i++
        }

        while (bitsForCarbonDioxide.size() > 1) {
            if (bitsForCarbonDioxide*.getAt(j).countBy { it }.values().flatten().unique().size() == 1) {
                bitsForCarbonDioxide = bitsForCarbonDioxide.findAll { it[j] == '0' }
            } else {
                def firstBit = bitsForCarbonDioxide*.getAt(j).countBy { it }.min { it.value }.key
                bitsForCarbonDioxide = bitsForCarbonDioxide.findAll { it[j] == firstBit }
            }
            j++
        }

        Long.parseLong(bitsForOxygen.first().join(''), 2) *  Long.parseLong(bitsForCarbonDioxide.first().join(''), 2)
    }
}
