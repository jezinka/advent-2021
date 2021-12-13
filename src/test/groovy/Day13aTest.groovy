import spock.lang.Specification

class Day13aTest extends Specification {

    def "process"() {
        given:
        Map instructions = Day13a.prepareData('src/test/resources/input13')

        when:
        def result = Day13a.process(instructions)

        then:
        result == 17
    }
}
