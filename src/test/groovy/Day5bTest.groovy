import spock.lang.Specification

class Day5bTest extends Specification {

    def "process"() {
        given:
        List moves = Day5b.prepareData('src/test/resources/input5')

        when:
        def result = Day5b.process(moves)

        then:
        result == 12
    }

    def "prepareData"() {
        when:
        List moves = Day5b.prepareData('src/test/resources/input5')

        then:
        moves[0].join(',') == [0, 9, 5, 9].join(',')
        moves[1].join(',') == [8, 0, 0, 8].join(',')
    }
}
