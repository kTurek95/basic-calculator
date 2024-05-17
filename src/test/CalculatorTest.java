package test;
import basicCalculator.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * This class contains tests for the Calculator class, testing its ability to perform basic arithmetic operations.
 */
public class CalculatorTest {
    Calculator calculator = new Calculator();

    /**
     * Tests the addition operation.
     * Verifies that adding 4 and 6 results in 10.
     */
    @Test
    public void testAdd() {
        double result = calculator.add(4, 6);
        assertEquals(10, result, 0.1);
    }

    /**
     * Tests the subtraction operation.
     * Verifies that subtracting 2 from 10 results in 8.
     */
    @Test
    public void testSubtract() {
        double result = calculator.subtract(10, 2);
        assertEquals(8, result, 0.1);
    }

    /**
     * Tests the subtraction operation with a negative result.
     * Verifies that subtracting 10 from 2 results in -8.
     */
    @Test
    public void testNegativeSubtract() {
        double result = calculator.subtract(2, 10);
        assertEquals(-8, result, 0.1);
    }

    /**
     * Tests the multiplication operation.
     * Verifies that multiplying 5 by 10 results in 50.
     */
    @Test
    public void testMultiply() {
        double result = calculator.multiply(5, 10);
        assertEquals(50, result, 0.1);
    }

    /**
     * Tests the division operation.
     * Verifies that dividing 15 by 5 results in 3.
     */
    @Test
    public void testDivide() {
        double result = calculator.divide(15, 5);
        assertEquals(3, result, 0.1);
    }

    /**
     * Tests the division operation when dividing by zero.
     * Verifies that dividing 5 by 0 is handled appropriately, assumed to return 0 in this test.
     */
    @Test
    public void testDivideByZero() {
        double result = calculator.divide(5, 0);
        assertEquals(0, result, 0.1);
    }

    /**
     * Tests the division operation with a decimal result.
     * Verifies that dividing 5 by 2 results in 2.5.
     */
    @Test
    public void testDivideDecimalFractionResult() {
        double result = calculator.divide(5, 2);
        assertEquals(2.5, result, 0.1);
    }

    /**
     * Tests the exponentiation operation.
     * Verifies that raising 2 to the power of 2 results in 4.
     */
    @Test
    public void testExponentiation() {
        double result = calculator.exponentiation(2, 2);
        assertEquals(4, result, 0.1);
    }
}
