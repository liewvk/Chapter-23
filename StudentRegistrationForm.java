import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField studentIdField = new JTextField();
        JTextField nameField = new JTextField();

        String[] courses = {"Java Programming", "Python Programming", "Web Development", "Database"};
        JComboBox<String> courseBox = new JComboBox<>(courses);

        JTextField markField = new JTextField();

        JButton submitButton = new JButton("Submit");

        panel.add(new JLabel("Student ID:"));
        panel.add(studentIdField);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Course:"));
        panel.add(courseBox);

        panel.add(new JLabel("Mark:"));
        panel.add(markField);

        panel.add(new JLabel(""));
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String name = nameField.getText().trim();
            String course = (String) courseBox.getSelectedItem();
            String markText = markField.getText().trim();

            if (studentId.isEmpty() || name.isEmpty() || markText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please complete all fields.");
                return;
            }

            try {
                double mark = Double.parseDouble(markText);

                if (mark < 0 || mark > 100) {
                    JOptionPane.showMessageDialog(frame, "Mark must be between 0 and 100.");
                    return;
                }

                String grade = getGrade(mark);

                String message = "Student Registration Successful\n\n"
                        + "Student ID: " + studentId + "\n"
                        + "Name: " + name + "\n"
                        + "Course: " + course + "\n"
                        + "Mark: " + mark + "\n"
                        + "Grade: " + grade;

                JOptionPane.showMessageDialog(frame, message);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid mark.");
            }
        });

        frame.add(panel);

        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static String getGrade(double mark) {
        if (mark >= 80) {
            return "A";
        } else if (mark >= 70) {
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
