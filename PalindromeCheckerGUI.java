import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeCheckerGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton checkButton, clearButton;

    public PalindromeCheckerGUI() {
        setTitle("Advanced Palindrome Checker");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Enter a word/phrase: ");
        inputField = new JTextField(25);
        topPanel.add(inputLabel);
        topPanel.add(inputField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        checkButton = new JButton("Check Palindrome");
        clearButton = new JButton("Clear");
        buttonPanel.add(checkButton);
        buttonPanel.add(clearButton);

        // Result Panel
        resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        checkButton.addActionListener(e -> checkPalindrome());
        clearButton.addActionListener(e -> clearFields());
    }

    private void checkPalindrome() {
        String input = inputField.getText();
        if (input.isEmpty()) {
            resultArea.setText("Please enter a word or phrase.");
            return;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(cleaned).reverse();

        boolean isPalindrome = cleaned.equals(reversed.toString());

        resultArea.setText("");
        resultArea.append("Original Input: " + input + "\n");
        resultArea.append("Processed Text: " + cleaned + "\n");
        resultArea.append("Reversed Text:  " + reversed + "\n");
        resultArea.append("Palindrome: " + (isPalindrome ? "YES ✅" : "NO ❌") + "\n");

        if (!isPalindrome) {
            resultArea.append("\nMismatch found at character comparison!\n");
        }
    }

    private void clearFields() {
        inputField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PalindromeCheckerGUI().setVisible(true);
        });
    }
}
