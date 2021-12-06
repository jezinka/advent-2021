import spock.lang.Specification

class Day6aTest extends Specification {

    def "process"() {
        given:
        List stages = [3, 4, 3, 1, 2]

        when:
        def result = Day6a.process(stages, days)

        then:
        result == expectedResult

        where:
        days | expectedResult
        18   | 26
        80   | 5934
    }
}
