import spock.lang.Specification

class Day11bTest extends Specification {

    def "process"() {
        given:
        List octopuses = Day11b.prepareData('src/test/resources/input11')

        when:
        def result = Day11b.process(octopuses)

        then:
        result == 195
    }
}
