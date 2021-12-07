import spock.lang.Specification

class Day7bTest extends Specification {

    def "process"() {
        given:
        List crabs = [16, 1, 2, 0, 4, 2, 7, 1, 2, 14]

        when:
        def result = Day7b.process(crabs)

        then:
        result == 168
    }

    def "findFuel"() {
        given:
        List crabs = [16, 1, 2, 0, 4, 2, 7, 1, 2, 14]
        Long[] fuel = new Long[17]
        fuel[0] = 0
        fuel[1] = 1

        when:
        def fuelSum = crabs.collect {
            Day7b.findFuel(Math.abs(position - it), fuel)
        }.sum()

        println(fuel.join(','))

        then:
        fuelSum == expectedSum

        where:
        position | expectedSum
        5        | 168
        2        | 206
    }
}
