import org.junit.Test;

import static org.junit.Assert.*;

public class CustomCalculatorTest {
    private CustomCalculator customCalculator = new CustomCalculator();

    @Test
    public void add() {
        int result = customCalculator.add(3, 5);
        // 기댓값, 실제값, 허용 오차
        assertEquals(5, result, 3);
    }

    @Test
    public void subtract() {
        int result = customCalculator.subtract(10, 1);
        assertTrue(result==9);
        assertEquals(7, result, 2);
        assertEquals(7, result, 1);
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }

}