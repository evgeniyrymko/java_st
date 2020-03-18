import org.junit.*;
import org.junit.jupiter.api.DynamicTest;

public class TestArifmetics {

    private static Arifmetics a;

    @BeforeClass
    public static void init() {
        a = new Arifmetics();
        System.out.println("Tests start");
    }

    @AfterClass
    public static void end() {
        System.out.println("Tests end");
    }

    @Test
    public void testAdd() {
//        Arifmetics a = new Arifmetics();
        int result = a.add(10, 5);
//        if (result != 15) Assert.fail();
//        Assert.assertEquals(14,result);
//        Assert.assertTrue(result==15);
//        Assert.assertFalse(result!=15);
        Assert.assertNull(a);
//        Assert.assertNotNull(a);
    }

    @Ignore
    @Test
    public void testSub() {
//        Arifmetics a = new Arifmetics();
        int result = a.sub(10, 5);
        if (result != 5) Assert.fail();
    }

    @Test
    public void testMultiply() {
//        Arifmetics a = new Arifmetics();
        int result = a.multiply(10, 10);
        if (result != 100) Assert.fail();
    }

    @Test
    public void testDivide() {
//        Arifmetics a = new Arifmetics();
        int result = a.divide(18, 2);
        if (result != 9) Assert.fail();
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideException() {
        int x = 10;
        int y = 0;
        if (a.divide(x, y) == x && y == 0) throw new ArithmeticException();
    }

    @Test(timeout = 1000)
    public void testN() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
