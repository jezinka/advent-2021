import spock.lang.Specification

class Day11aTest extends Specification {

    def "simple process"() {
        given:
        List octopuses = [[1, 1, 1, 1, 1],
                          [1, 9, 9, 9, 1],
                          [1, 9, 1, 9, 1],
                          [1, 9, 9, 9, 1],
                          [1, 1, 1, 1, 1]]

        when:
        def result = Day11a.process(octopuses, 2)

        then:
        result == 9
    }

    def "process"() {
        given:
        List octopuses = Day11a.prepareData('src/test/resources/input11test.txt')

        when:
        def result = Day11a.process(octopuses, 100)

        then:
        result == 1656
    }
}
