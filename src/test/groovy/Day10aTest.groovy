import spock.lang.Specification

class Day10aTest extends Specification {

    def "process"() {
        given:
        List map = Day10a.prepareData('src/test/resources/input10test.txt')

        when:
        def result = Day10a.process(map)

        then:
        result == 26397
    }
}
