package by.java.spocktesting.account

import spock.lang.Specification
import spock.lang.Unroll

class AccountExampleTest8 extends Specification {

    @Unroll
    def "Withdraw"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(amount)

        then:
        account.balance == old(account.balance) - amount

        where:
        balance | amount
        5.0     | 2.0
        10.0    | 0.0
        6.0     | 6.0

    }

}