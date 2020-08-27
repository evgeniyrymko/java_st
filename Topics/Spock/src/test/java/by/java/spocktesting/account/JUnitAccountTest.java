package by.java.spocktesting.account;

import by.java.spocktesting.account.Account;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class JUnitAccountTest {

    @Test
    public void withdrawPositiveAmount() {
        // given
        Account account = new Account(BigDecimal.valueOf(5));

        // when
        account.withdraw(BigDecimal.valueOf(2));

        // then
        Assert.assertEquals(BigDecimal.valueOf(3), account.getBalance());
    }
}
