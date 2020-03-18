package rymko.bookingdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    public void test() {
        int x = 23;
        int y = 5;
        Assertions.assertEquals(28, x + y);
    }
}
