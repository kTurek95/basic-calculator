package test;
import basicCalculator.Main;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * This class contains tests for the Main class, specifically testing user input processing.
 */
public class MainTest {

    /**
     * Tests the getUserNumbers method from the Main class to ensure it correctly processes and returns user input as an array of integers.
     * Simulates user input of "5" and "10" via a ByteArrayInputStream, and verifies that the method returns the correct array of integers.
     */
    @Test
    public void testGetUserNumbersCorrectInput() {
        int[] expectedResult = {5, 10}; // Expected output array
        System.setIn(new java.io.ByteArrayInputStream("5\n10\n".getBytes())); // Simulate user input

        int[] result = Main.getUserNumbers(); // Execute the method to test

        assertArrayEquals(expectedResult, result); // Verify the output matches the expected result
    }

}
