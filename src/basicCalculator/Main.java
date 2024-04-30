package basicCalculator;

import java.util.Scanner;

/**
 * The Main class of the basic calculator program that handles user interaction and performs basic arithmetic operations.
 */

public class Main {
    /**
     * The main method that drives the application, handling user input and coordinating responses based on selected actions.
     *
     * @param args The command-line arguments for the application.
     */

    public static void main(String[] args)
    {

        Calculator calc = new Calculator();

        Scanner sc = new Scanner(System.in);

        int userChoice = -1;

        menu();


        do
        {
            try
            {
                System.out.print("Choose what you want to do(To display the menu, press 0 or 9 if you want to exit): ");
                userChoice = sc.nextInt();
            } catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid data format. Please enter an integer.");
                sc.nextLine();
                continue;
            }
            if (userChoice == 1)
            {
                int[] userArray = getUserNumbers();

                System.out.println("Result of addition is: " + calc.add(userArray[0], userArray[1]));

            }
            else if (userChoice == 2)
            {
                int[] userArray = getUserNumbers();

                System.out.println("Result of subtraction is: " + calc.subtract(userArray[0], userArray[1]));
            }
            else if (userChoice == 3)
            {

                int[] userArray = getUserNumbers();

                System.out.println("Result of multiplication is: " + calc.multiply(userArray[0], userArray[1]));
            }
            else if (userChoice == 4)
            {

                int[] userArray = getUserNumbers();

                System.out.println("Result of division is: " + calc.divide(userArray[0], userArray[1]));
            }
            else if (userChoice == 5)
            {
                int[] userArray = getUserNumbers();
                System.out.println("Result of exponentiation is: " + calc.exponentiation(userArray[0], userArray[1]));
            }

            else if (userChoice == 0)
            {
                menu();
            }
            else
            {
                if (userChoice != 9)
                {
                    System.out.println("There is no such option");
                }
            }
        } while (userChoice != 9);

    }

    /**
     * Prompts the user to enter two integers and returns them in an array.
     * Handles input mismatch exceptions by prompting the user again until valid integers are entered.
     *
     * @return An array of two integers entered by the user.
     */
    public static int[] getUserNumbers()
    {
        Scanner sc = new Scanner(System.in);

        int userNumber1;
        int userNumber2;

        do
        {
            try
            {
                System.out.print("Enter the first number: ");
                userNumber1 = sc.nextInt();
                System.out.print("Enter the second number: ");
                userNumber2 = sc.nextInt();
                break;
            } catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid data format. Please enter an integer.");
                sc.nextLine();
            }
        } while (true);

        int[] userArray = new int[2];
        userArray[0] = userNumber1;
        userArray[1] = userNumber2;

        return userArray;

    }

    /**
     * Displays a menu to the user with options for various arithmetic operations and exiting the program.
     */
    public static void menu()
    {
        System.out.println("                     Basic Calculator");
        System.out.println("In this  calculator you can add, subtract, multiply, and divide");
        System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exponentiation \n9. Exit");
    }
}