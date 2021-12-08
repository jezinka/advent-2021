import spock.lang.Specification

class Day8aTest extends Specification {

    def "process"() {
        given:
        List displays = ['fdgacbe', 'cefdb', 'cefbgd', 'gcbe',
                         'fcgedb', 'cgb', 'dgebacf', 'gc',
                         'cg cg', 'fdcagb', 'cbg', '',
                         'efabcd', 'cedba', 'gadfec', 'cb',
                         'gecf', 'egdcabf', 'bgf', 'bfgea',
                         'gebdcfa', 'ecba', 'ca', 'fadegcb',
                         'cefg', 'dcbef', 'fcge', 'gbcadfe',
                         'ed bcgafe', 'cdgba', 'cbgef',
                         'gbdfcae', 'bgc', 'cg', 'cgb',
                         'fgae', 'cfgab', 'fg', 'bagce']

        when:
        def result = Day8a.process(displays)

        then:
        result == 26
    }
}
