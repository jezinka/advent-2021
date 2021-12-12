import spock.lang.Specification

class Day2bTest extends Specification {
    def "process"() {
        given:
        List moves = Day2b.prepareData('src/test/resources/input2')

        when:
        def result = Day2b.process(moves)

        then:
        result == 900
    }
}
