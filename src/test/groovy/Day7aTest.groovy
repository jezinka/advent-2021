import spock.lang.Specification

class Day7aTest extends Specification {

    def "process"() {
        given:
        List crabs = [16, 1, 2, 0, 4, 2, 7, 1, 2, 14]

        when:
        def result = Day7a.process(crabs)

        then:
        result == 37
    }
}
