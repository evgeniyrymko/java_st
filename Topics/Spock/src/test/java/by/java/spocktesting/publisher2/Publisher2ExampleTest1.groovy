package by.java.spocktesting.publisher2

import spock.lang.Specification


class Publisher2ExampleTest1 extends Specification {
    def pub = new Publisher2()
    def sub1 = Mock(Subscriber2)
    def sub2 = Mock(Subscriber2)

    def setup() {
        pub.subscribers << sub1 << sub2
    }

    def "deliver message to all active subscribers"() {
        given:
        sub1.active >> true
        sub2.active >> false

        when:
        pub.publish("message 1")

        then:
        1 * sub1.receive("message 1")
        0 * sub1.receive(_)
    }

}