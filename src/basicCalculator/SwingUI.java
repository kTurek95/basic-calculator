package basicCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SwingUI class creates a basic calculator user interface using Java Swing.
 *
 * This class extends JFrame and sets up a simple calculator interface with
 * buttons for digits, basic arithmetic operations, and additional functions
 * like clearing input, changing the sign of a number, and exponentiation.
 *
 * It includes the following functionalities:
 * - Displaying numbers and operations in a non-editable text field.
 * - Handling button clicks to update the display and perform calculations.
 * - Basic arithmetic operations: addition, subtraction, multiplication, and division.
 * - Clearing the current input.
 * - Changing the sign of the current number.
 * - Exponentiation.
 *
 * Methods:
 * - SwingUI(): Constructor that sets up the calculator frame, initializes components, and adds them to the frame.
 * - initCalculatorButtons(): Initializes the calculator buttons and assigns action listeners to handle button clicks.
 * - initComponents(): Initializes the text field to display the chosen buttons and results.
 * - addComponentsToFrame(): Adds the text field and buttons to the frame using GridBagLayout.
 */
public class SwingUI extends JFrame {

    private JTextField chosenButton;
    private static double result = 0;
    private static double num1 = 0;
    private static String operator = "";
    private static String buttonNumbers = "";
    private static JButton[] buttons;

    private static Calculator calculator = new Calculator();

    /**
     * Constructor that sets up the calculator frame, initializes components, and adds them to the frame.
     */
    public SwingUI()
    {
        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,300);

        initCalculatorButtons();
        initComponents();
        addComponentsToFrame();
    }

    /**
     * Initializes the calculator buttons and assigns action listeners to handle button clicks.
     */
    public void initCalculatorButtons()
    {
        String[] buttonLabels = {"7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "+/-", "x^"};

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            buttons[i] = button;
        }

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String digit = buttons[index].getText();
                    if (digit.matches("[0-9]")) {
                        buttonNumbers += digit;
                        chosenButton.setText(buttonNumbers);
                    } else if (digit.equals("+") || digit.equals("-") || digit.equals("*") || digit.equals("/") || digit.equals("x^")) {
                        num1 = Double.parseDouble(chosenButton.getText());
                        operator = digit;
                        chosenButton.setText("");
                        buttonNumbers = "";
                    } else if (digit.equals("C")) {

                        result = 0;
                        chosenButton.setText("");
                        buttonNumbers = "";
                    } else if (digit.equals("+/-")) {
                        double number = Double.parseDouble(chosenButton.getText());
                        double negatedNumber = number * -1;
                        chosenButton.setText(String.valueOf(negatedNumber));
                    } else if (digit.equals("=")) {
                        double num2 = Double.parseDouble(chosenButton.getText());
                        switch (operator) {
                            case "+":

                                result = calculator.add(num1, num2);
                                break;
                            case "-":
                                result = calculator.subtract(num1, num2);
                                break;
                            case "*":
                                result = calculator.multiply(num1, num2);
                                break;
                            case "/":
                                if (num2 != 0) {
                                    result = calculator.divide(num1, num2);
                                } else {
                                    chosenButton.setText("Error");
                                    return;
                                }
                                break;
                            case "x^":
                                result = calculator.exponentiation(num1, num2);
                        }
                        chosenButton.setText(String.valueOf(result));
                    }
                }
            });
        }
    }

    /**
     * Initializes the text field to display the chosen buttons and results.
     */
    public void initComponents()
    {
        chosenButton = new JTextField();
        chosenButton.setEditable(false);
    }

    /**
     * Adds the text field and buttons to the frame using GridBagLayout.
     */
    public void addComponentsToFrame()
    {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        getContentPane().add(chosenButton, gbc);

        gbc.weightx = 0;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        getContentPane().add(buttons[8], gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        getContentPane().add(buttons[9], gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        getContentPane().add(buttons[10], gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        getContentPane().add(buttons[15], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        getContentPane().add(buttons[4], gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        getContentPane().add(buttons[5], gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        getContentPane().add(buttons[6], gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        getContentPane().add(buttons[11], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        getContentPane().add(buttons[0], gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        getContentPane().add(buttons[1], gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        getContentPane().add(buttons[2], gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        getContentPane().add(buttons[7], gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        getContentPane().add(buttons[12], gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        getContentPane().add(buttons[16], gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        getContentPane().add(buttons[13], gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        getContentPane().add(buttons[3], gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        getContentPane().add(buttons[17], gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        getContentPane().add(buttons[14], gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 5;
        getContentPane().add(buttons[18], gbc);

    }
}
