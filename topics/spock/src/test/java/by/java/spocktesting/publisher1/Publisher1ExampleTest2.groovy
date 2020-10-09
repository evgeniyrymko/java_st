package by.java.spocktesting.publisher1

import spock.lang.Specification
import spock.lang.Unroll


class Publisher1ExampleTest2 extends Specification {
    def pub = new Publisher1()
    def sub1 = Mock(Subscriber1)
    def sub2 = Mock(Subscriber1)

    def setup() {
        pub.subscribers << sub1 << sub2
    }

    @Unroll
    def "delivers messages to all active subscribers"() {
        when:
        pub.publish("message 1")

        then:
        1 * sub1.receive("message 1") >> { throw new Exception() }
        1 * sub2.receive("message 1")
    }

}