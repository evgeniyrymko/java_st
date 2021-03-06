package by.java.spocktesting.account

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class AccountExampleTest9 extends Specification {
    @Shared
            sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table accountdata (id int primary key, balance decimal, withdrawn decimal, remaining decimal)")
        sql.execute("insert into accountdata values (1, 5.0, 2.0, 3.0), (2, 4.0, 0.0, 4.0), (3, 4.0, 4.0, 0.0)")
    }

    def "withdrawing #withdrawn from account with balance #balance leaves #remaining"() {
        given:
        def account = new Account(balance)

        when:
        account.withdraw(withdrawn)

        then:
        account.balance == remaining

        where:
        [balance, withdrawn, remaining] << sql.rows("select balance, withdrawn, remaining from accountdata")
    }
}