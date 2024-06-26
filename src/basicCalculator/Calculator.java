package basicCalculator;
import java.lang.Math;

/**
 * The Calculator class provides basic arithmetic functions such as addition, subtraction, multiplication, division, and exponentiation.
 */
public class Calculator {
    /**
     * Adds two doubles.
     *
     * @param value1 The first double to be added.
     * @param value2 The second double to be added.
     * @return The sum of value1 and value2.
     */
    public double add(double value1, double value2)
    {
        return value1 + value2;
    }

    /**
     * Subtracts the second double from the first.
     *
     * @param value1 The double from which value2 will be subtracted.
     * @param value2 The double to subtract from value1.
     * @return The difference between value1 and value2.
     */
    public double subtract(double value1, double value2)
    {
        if (value2 > value1)
        {
            System.out.println("The result obtained will be negative");
        }
        return value1 - value2;
    }

    /**
     * Multiplies two doubles.
     *
     * @param value1 The first double to multiply.
     * @param value2 The second double to multiply.
     * @return The product of value1 and value2.
     */
    public double multiply(double value1, double value2)
    {
        return value1 * value2;
    }

    /**
     * Divides the first double by the second, checking for division by zero.
     *
     * @param value1 The dividend.
     * @param value2 The divisor; must not be zero.
     * @return The quotient of value1 and value2 if value2 is not zero; otherwise, returns 0.
     */
    public double divide(double value1, double value2)
    {
        if (value2 == 0)
        {
            System.out.println("You cannot divide by zero");
            return 0;
        }

        return value1 / value2;
    }

    /**
     * Raises the first double to the power of the second double using exponentiation.
     *
     * @param value1 The base.
     * @param value2 The exponent.
     * @return value1 raised to the power of value2.
     */
    public double exponentiation(double value1, double value2)
    {
        return Math.pow(value1, value2);
    }
}
