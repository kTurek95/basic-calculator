package test;
import basicCalculator.Main;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        int[] expectedResult = {5, 10};
        InputStream originalIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream("5\n10\n".getBytes()));
            int[] result = Main.getUserNumbers();
            assertArrayEquals(expectedResult, result);
        } finally {
            System.setIn(originalIn);
        }
    }
}
