package by.java.spocktesting.publisher1

import spock.lang.Specification


class Publisher1ExampleTest3 extends Specification {
    def pub = new Publisher1()
    def sub1 = Mock(Subscriber1)

    def setup() {
        pub.subscribers << sub1
    }

    def "messages should be received in right order"() {
        when:
        pub.publish("message 1")
        pub.publish("message 2")

        then:
        1 * sub1.receive("message 1")

        then:
        1 * sub1.receive("message 2")
    }
}