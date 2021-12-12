import spock.lang.Specification

class Day2aTest extends Specification {
    def "process"() {
        given:
        List moves = Day2a.prepareData('src/test/resources/input2')

        when:
        def result = Day2a.process(moves)

        then:
        result == 150
    }
}
