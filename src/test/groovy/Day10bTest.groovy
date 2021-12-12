import spock.lang.Specification

class Day10bTest extends Specification {

    def "process"() {
        given:
        List map = Day10b.prepareData('src/test/resources/input10')

        when:
        def result = Day10b.process(map)

        then:
        result == 288957
    }
}
