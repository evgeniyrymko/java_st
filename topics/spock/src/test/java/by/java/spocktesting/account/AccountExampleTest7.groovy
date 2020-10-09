package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class AccountExampleTest7 extends Specification {
    def "Withdraw"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(amount)

        then:
        account.balance == remainingBalance

        where:
        balance | amount | remainingBalance
        5.0     | 2.0    | 3.0
        10.0    | 3.0    | 7.0
        6.0     | 2.0    | 4.0
        6.0     | 6.0    | 0
        16.0    | 8.0    | 8.0
        7.0     | 2.0    | 5.0
        9.0     | 8.0    | 1.0
    }

}