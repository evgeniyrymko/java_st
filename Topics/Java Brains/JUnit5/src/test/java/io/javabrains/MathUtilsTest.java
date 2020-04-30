package io.javabrains;

import org.junit.Assert;
import org.junit.Before;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Running of MathUtilsTest class")
public class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

//    @BeforeAll
//    public void beforeAllInit() {
//        System.out.println("This needs to run before all...");
//    }

    @BeforeEach
    public void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
    }

//    @AfterEach
//    public void cleanup() {
//        System.out.println("Cleaning up...");
//    }


    @Nested
    @DisplayName("add() method")
    class AddTest {
        @Test
        @DisplayName("when adding two positive numbers")
        public void testAddPositive() {
            Assert.assertEquals("should return the right result", 4, mathUtils.multiply(2, 2));
        }

        @Test
        @DisplayName("when adding two negative numbers")
        public void testAddNegative() {
            int expected = -4;
            int actual = mathUtils.multiply(-2, 2);
            Assert.assertEquals("should return " + expected + " but return " + actual, expected, actual);
        }
    }


    @Test
    @DisplayName("Multiply method (AssertAll testing)")
    public void testMultiply() {
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        Assertions.assertAll(
                () -> Assert.assertEquals("Should returt the right result", 4, mathUtils.multiply(2, 2)),
                () -> Assert.assertEquals("Should returt the right result", 6, mathUtils.multiply(3, 2)),
                () -> Assert.assertEquals("Should returt the right result", 8, mathUtils.multiply(4, 2))
        );
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testDivide() {
        boolean isServerUp = false;
        Assumptions.assumeTrue(isServerUp);
        Assert.assertThrows(ArithmeticException.class, () -> mathUtils.divide(2, 0));
    }

    @RepeatedTest(2)
    public void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        double expected = Math.PI * 10 * 10;
        Assert.assertEquals(expected, mathUtils.computeCircleArea(10), 0.5);
    }

    @Test
    @DisplayName("TDD testDisabled() should not run")
    @Disabled
    public void testDisabled() {
        Assert.fail("Test of testDisabled() was failed...");
    }

}
