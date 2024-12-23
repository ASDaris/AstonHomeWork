import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.example.Main.calculateFactorial;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;


public class FactorialTest {

    @Test(description = "ParameterizedTest", dataProvider = "provideInputs")
    public void  factorialParameterizedTest(int input, int expected) {
        assertEquals(expected, calculateFactorial(input));
    }

    @Test
    public void  factorialThrowsExceptionTest(){
        assertThrows(ArithmeticException.class, () -> calculateFactorial(-1));
    }

    @DataProvider(name = "provideInputs")
    private static Object[][] provideInputs() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720}
        };
    }
}
