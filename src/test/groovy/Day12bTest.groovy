import spock.lang.Specification
import spock.lang.Unroll

class Day12bTest extends Specification {

    def "process"() {
        given:
        List connections = Day12b.prepareData(filePath)

        when:
        def result = Day12b.process(connections)

        then:
        result == expectedResult

        where:
        filePath                       | expectedResult
        'src/test/resources/input12-1' | 36
        'src/test/resources/input12-2' | 103
        'src/test/resources/input12-3' | 3509
    }

    @Unroll
    def "canVisitSmallCave"() {

        expect:
        expectedResult == Day12b.canVisitSmallCave(cave, path)

        where:
        cave | path            | expectedResult
        'a'  | []              | true
        'a'  | ['b']           | true
        'a'  | ['a', 'b']      | true
        'a'  | ['a', 'a']      | false
        'a'  | ['a', 'b', 'b'] | false
        'a'  | ['c', 'b', 'b'] | true
    }
}
