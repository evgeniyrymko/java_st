package by.java.spocktesting.publisher3

import spock.lang.Specification


class Publisher3ExampleTest1 extends Specification {
    def pub = new Publisher3()
    def sub1 = Mock(Subscriber3)
    def sub2 = Mock(Subscriber3)

    def setup() {
        pub.subscribers << sub1 << sub2
    }

    def "exception should be thrown after message fail"() {
        when:
        pub.publish("message 1")

        then: "when subscriber returns fail - publisher should throw exception"
        1 * sub1.receive("message 1") >> "fail"
        0 * sub1.receive(_) >> "ok"
    }

}