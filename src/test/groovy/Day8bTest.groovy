import spock.lang.Specification

class Day8bTest extends Specification {

    def "process"() {
        given:
        List displays = Day8b.prepareData('src/test/resources/input8test.txt')

        when:
        def result = Day8b.process(displays)

        then:
        result == 5353
    }
}
