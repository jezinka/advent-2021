import spock.lang.Specification

class Day1bTest extends Specification {
    def "processWindow"() {
        given:
        List<Integer> depths = new File('src/test/resources/input1test.txt').readLines().collect { it as Integer}

        when:
        def result = Day1b.processWindow(depths)

        then:
        result == 5
    }
}
