import spock.lang.Specification

class Day9aTest extends Specification {

    def "process"() {
        given:
        List map = Day9a.prepareData('src/test/resources/input9')

        when:
        def result = Day9a.process(map)

        then:
        result == 15
    }
}
