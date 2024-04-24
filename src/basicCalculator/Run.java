package basicCalculator;
import test.CalculatorTest;
import test.MainTest;
import java.io.IOException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * The Run class provides the main entry point for the program and handles different modes of operation.

 * It supports two primary modes:
 * 1. "test" - Runs unit tests for the main and calculator components, and logs the results to a file.
 * 2. "menu" - Starts the main application.

 * If no valid command line argument is provided, the program will output "No such option".

 * This class also contains commented-out code for handling input through the terminal if not run with
 * initial arguments. This is useful for environments without integrated development environments (IDEs)
 * like IntelliJ, where command line arguments are typically configured.
 */
public class Run {
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            if (args[0].equals("test"))
            {
                FileWriter myFile = new FileWriter("testsResult.txt");
                Result mainTest = JUnitCore.runClasses(MainTest.class);
                Result calculatorTest = JUnitCore.runClasses(CalculatorTest.class);

                myFile.write("Has the test for mainTest passed?: " + mainTest.wasSuccessful() + "\n");
                myFile.write("Has the test for calculatorTest passed?: " + calculatorTest.wasSuccessful());

                myFile.close();
            } else if (args[0].equals("menu"))
            {
                Main.main(args);
            }
            else
            {
                System.out.println("No such option");
            }
        }


        // Uncomment the following section if you need to handle input from the terminal without initial arguments
        /*
        Scanner sc = new Scanner(System.in);

        System.out.print("To run the program, choose 0; to run the tests, choose 1: ");
        int userChoice = sc.nextInt();

        if (userChoice == 1) {
            FileWriter myFile = new FileWriter("testsResult.txt");
            Result mainTest = JUnitCore.runClasses(MainTest.class);
            Result calculatorTest = JUnitCore.runClasses(CalculatorTest.class);

            myFile.write("Has the test for mainTest passed?: " + mainTest.wasSuccessful() + "\n");
            myFile.write("Has the test for calculatorTest passed?: " + calculatorTest.wasSuccessful());

            myFile.close();
        } else if (userChoice == 0) {
            Main.main(args);
        } else {
            System.out.println("No such option");
        }
        */
    }
}
