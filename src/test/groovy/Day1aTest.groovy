import spock.lang.Specification

class Day1aTest extends Specification {
    def "process"() {
        given:
        List<Integer> depths = new File('src/test/resources/input1').readLines().collect { it as Integer}

        when:
        def result = Day1a.process(depths)

        then:
        result == 7
    }
}
