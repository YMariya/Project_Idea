package Package;


import Calc.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;

@DisplayName("Набор тестов калькулятора")
public class FirstTest {


    @Test
    public void resultMinusPositive() {
        Min min = new Min();
        assertEquals(-5.5f, min.solve(-10.0, -4.5), 0);
    }

    @Test
    public void resultSummaPositive() {
        Sum sum = new Sum();
        assertEquals(25.0, sum.solve(5.5, 20.0), 0.0);
    }

    @Test
    public void resultMultiplyPositive() {
        Mult mult = new Mult();
        assertEquals(25, mult.solve(5.0, 5.0), 0);
    }

    @Test
    public void resultDividePositive() {
        Del del = new Del();
        assertEquals(2.5, del.solve(5.0, 2.0), 0);
    }

    @Test
    public void resultDivideIllegalArgument() {
        Del del = new Del();
        Assertions.assertThrows(ArithmeticException.class, () -> del.solve(7.0, 0.0));
    }
}


