package by.java.spocktesting.account

import by.java.spocktesting.account.Account
import spock.lang.Specification

class AccountExampleTest1 extends Specification {
    def "Withdraw"() {
        given:
        Account account = new Account(BigDecimal.valueOf(5))

        when:
        account.withdraw(BigDecimal.valueOf(3))

        then:
        account.getBalance() == BigDecimal.valueOf(2)
    }

} 
