import spock.lang.Specification

class Day3aTest extends Specification {
    def "process"() {
        given:
        List moves = Day3a.prepareData('src/test/resources/input3test.txt')

        when:
        def result = Day3a.process(moves)

        then:
        result == 198
    }
}
