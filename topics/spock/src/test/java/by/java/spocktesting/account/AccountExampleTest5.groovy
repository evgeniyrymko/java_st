package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import by.java.spocktesting.account.NegativeAmountWithdrawnException
import spock.lang.Specification

class AccountExampleTest5 extends Specification {
    def "Withdraw negative amount"() {
        given:
        def account = new Account(5)

        when:
        account.withdraw(-1)

        then:
        thrown(NegativeAmountWithdrawnException)
    }
}
