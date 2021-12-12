import spock.lang.Specification

class Day3bTest extends Specification {
    def "process"() {
        given:
        List moves = Day3b.prepareData('src/test/resources/input3')

        when:
        def result = Day3b.process(moves)

        then:
        result == 230
    }
}
