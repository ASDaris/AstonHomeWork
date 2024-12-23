import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import static org.example.Main.calculateFactorial;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @ParameterizedTest(name = "Result: {0}, Expected result: {1}")
    @MethodSource("provideInputs")
    public void  factorialParameterizedTest(int input, int expected) {
        assertEquals(expected, calculateFactorial(input));
    }

    @Test
    @Description("Check negative number")
    public void factorialThrowExceptionTest() {
        assertThrows(ArithmeticException.class, () -> calculateFactorial(-1));
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 2),
                Arguments.arguments(3, 6),
                Arguments.arguments(4, 24),
                Arguments.arguments(5, 120),
                Arguments.arguments(6, 720)
        );
    }
}
