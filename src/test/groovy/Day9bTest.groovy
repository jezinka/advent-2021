import spock.lang.Specification

class Day9bTest extends Specification {

    def "process"() {
        given:
        List map = Day9b.prepareData('src/test/resources/input9')

        when:
        def result = Day9b.process(map)

        then:
        result == 1134
    }
}
