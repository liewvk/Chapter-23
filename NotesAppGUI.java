import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotesAppGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Notes App");

        JTextArea notesArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(notesArea);

        JPanel buttonPanel = new JPanel();

        JButton clearButton = new JButton("Clear");
        JButton showButton = new JButton("Show Notes");

        buttonPanel.add(clearButton);
        buttonPanel.add(showButton);

        clearButton.addActionListener(e -> {
            notesArea.setText("");
        });

        showButton.addActionListener(e -> {
            String notes = notesArea.getText().trim();

            if (notes.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No notes entered.");
            } else {
                JOptionPane.showMessageDialog(frame, notes);
            }
        });

        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
