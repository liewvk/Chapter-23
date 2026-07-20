import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField number1Field = new JTextField();
        JTextField number2Field = new JTextField();
        JTextField resultField = new JTextField();

        resultField.setEditable(false);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        panel.add(new JLabel("Number 1:"));
        panel.add(number1Field);

        panel.add(new JLabel("Number 2:"));
        panel.add(number2Field);

        panel.add(new JLabel("Result:"));
        panel.add(resultField);

        panel.add(addButton);
        panel.add(subtractButton);

        panel.add(multiplyButton);
        panel.add(divideButton);

        addButton.addActionListener(e -> calculate(frame, number1Field, number2Field, resultField, "+"));
        subtractButton.addActionListener(e -> calculate(frame, number1Field, number2Field, resultField, "-"));
        multiplyButton.addActionListener(e -> calculate(frame, number1Field, number2Field, resultField, "*"));
        divideButton.addActionListener(e -> calculate(frame, number1Field, number2Field, resultField, "/"));

        frame.add(panel);

        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void calculate(JFrame frame, JTextField number1Field,
                                 JTextField number2Field, JTextField resultField,
                                 String operator) {
        try {
            double number1 = Double.parseDouble(number1Field.getText());
            double number2 = Double.parseDouble(number2Field.getText());

            double result = 0;

            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero.");
                        return;
                    }
                    result = number1 / number2;
                    break;
            }

            resultField.setText(String.format("%.2f", result));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
        }
    }
}
