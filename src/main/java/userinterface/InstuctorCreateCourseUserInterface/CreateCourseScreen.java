package userinterface.InstuctorCreateCourseUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateCourseScreen extends JFrame {
    private JTextField courseNameField;
    private JTextField prerequisiteField;
    private List<JTextField> questionFields;
    private List<JTextField> answerFields;
    private List<JTextField> pointsFields;

    public CreateCourseScreen() {
        // Initialize the JFrame
        setTitle("Create Course Screen");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the components
        courseNameField = new JTextField(20);
        prerequisiteField = new JTextField(20);

        questionFields = new ArrayList<>();
        answerFields = new ArrayList<>();
        pointsFields = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            questionFields.add(new JTextField(20));
            answerFields.add(new JTextField(20));
            pointsFields.add(new JTextField(5));
        }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        // Add components to the JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Course Name:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(courseNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Prerequisites:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(prerequisiteField, gbc);

        for (int i = 0; i < 3; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 2;
            mainPanel.add(new JLabel("Question #" + (i + 1) + ":"), gbc);
            gbc.gridx = 1;
            mainPanel.add(questionFields.get(i), gbc);

            gbc.gridx = 0;
            gbc.gridy = i + 5;
            mainPanel.add(new JLabel("Answer #" + (i + 1) + ":"), gbc);
            gbc.gridx = 1;
            mainPanel.add(answerFields.get(i), gbc);

            gbc.gridx = 0;
            gbc.gridy = i + 8;
            mainPanel.add(new JLabel("Points #" + (i + 1) + ":"), gbc);
            gbc.gridx = 1;
            mainPanel.add(pointsFields.get(i), gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = 11;
        mainPanel.add(saveButton, gbc);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Set the frame visible
        setVisible(true);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input values from the fields
            String courseId = courseNameField.getText();
            String prerequisite = prerequisiteField.getText();
            List<String> questions = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                questions.add(questionFields.get(i).getText());
                answers.add(answerFields.get(i).getText());
                try {
                    points.add(Integer.parseInt(pointsFields.get(i).getText()));
                } catch (NumberFormatException ex) {
                    showErrorMessage("Points must be numbers.");
                    return;
                }
            }

            // Perform validation checks
            if (courseId.isEmpty() || questions.contains("") || answers.contains("")) {
                showErrorMessage("Course Name, Questions, and Answers cannot be empty.");
                return;
            }

            // TODO: Connect to the database and save the course using InstructorCreateCourseUseCase

            // Show success message
            showSuccessMessage("Thank you, the course is saved.");
            // Clear fields
            clearFields();
        }

        private void showErrorMessage(String message) {
            JOptionPane.showMessageDialog(CreateCourseScreen.this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }

        private void showSuccessMessage(String message) {
            JOptionPane.showMessageDialog(CreateCourseScreen.this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        private void clearFields() {
            courseNameField.setText("");
            prerequisiteField.setText("");
            for (int i = 0; i < 3; i++) {
                questionFields.get(i).setText("");
                answerFields.get(i).setText("");
                pointsFields.get(i).setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateCourseScreen());
    }
}

