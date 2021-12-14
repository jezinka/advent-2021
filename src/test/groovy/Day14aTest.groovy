import spock.lang.Specification

class Day14aTest extends Specification {

    def "process"() {
        given:
        Map instructions = Day14a.prepareData('src/test/resources/input14')

        when:
        def result = Day14a.process(instructions)

        then:
        result == 1588
    }
}
