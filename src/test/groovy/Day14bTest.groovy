import spock.lang.Specification

class Day14bTest extends Specification {
    
    def "process for 14a"() {
        given:
        Map instructions = Day14a.prepareData('src/test/resources/input14')

        when:
        def result = Day14b.process(instructions, 10)

        then:
        result == 1588
    }

    def "process"() {
        given:
        Map instructions = Day14a.prepareData('src/test/resources/input14')

        when:
        def result = Day14b.process(instructions, 40)

        then:
        assert Long.MAX_VALUE > 2188189693529
        result == 2188189693529
    }
}
