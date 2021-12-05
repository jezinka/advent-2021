import spock.lang.Specification

class Day5aTest extends Specification {

    def "process"() {
        given:
        List moves = Day5a.prepareData('src/test/resources/input5test.txt')

        when:
        def result = Day5a.process(moves)

        then:
        result == 5
    }

    def "prepareData"() {
        when:
        List moves = Day5a.prepareData('src/test/resources/input5test.txt')

        then:
        moves[0].join(',') == [0, 9, 5, 9].join(',')
        moves.size() == 6
    }
}
