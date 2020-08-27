package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import spock.lang.Specification

class AccountExampleTest2 extends Specification {
    def "Withdraw"() {
        given:
        def account = new Account(5)
        account.metaClass.minus = account.&withdraw

        when:
        account - 2

        then:
        account.balance == 3
    }

}
