package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import spock.lang.Specification

class AccountExampleTest4 extends Specification {
    def "Withdraw" () {
        given: "account with balance 5"
        def account = new Account(5)
        account.metaClass.minus = account.&withdraw
        account.metaClass.plus = account.&deposit

        when: "account balance was withdrawn and deposited by the same amount"
        account - 2
        account + 2

        then: "same balance should remain"
        account.balance == old(account.balance)

    }

}
