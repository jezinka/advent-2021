import spock.lang.Specification

class Day12aTest extends Specification {

    def "process"() {
        given:
        List connections = Day12a.prepareData(filePath)

        when:
        def result = Day12a.process(connections)

        then:
        result == expectedResult

        where:
        filePath                       | expectedResult
        'src/test/resources/input12-1' | 10
        'src/test/resources/input12-2' | 19
        'src/test/resources/input12-3' | 226
    }
}
