package by.rymko

import spock.lang.Specification


class FirstSpecification extends Specification {

    def "one plus one should be equal two"() {
        expect:
        1 + 1 == 2
    }
}