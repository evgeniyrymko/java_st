package rymko.bookingdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoControllerTest {

    @Autowired
    private DemoController demoController;

    @Test
    void testHello() {
        Assertions.assertEquals("Hello", demoController.hello());
    }
}