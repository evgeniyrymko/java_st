package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import spock.lang.Specification

class AccountExampleTest3 extends Specification {
    def "Withdraw"() {
        given: "account with balance 5"
        def account = new Account(5)
        account.metaClass.minus = account.&withdraw

        when: "withdraw 2 from account"
        account - 2

        then: "3 is remaining as a balance"
        account.balance == 3

    }

}
