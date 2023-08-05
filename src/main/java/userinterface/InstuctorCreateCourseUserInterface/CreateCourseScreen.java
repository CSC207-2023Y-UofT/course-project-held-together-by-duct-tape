/**
 * Represents a user interface screen for creating a new course in instructor mode.
 * This class extends JPanel and implements ActionListener to handle user interactions.
 */

package userinterface.InstuctorCreateCourseUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import frameworksdrivers.DatabaseDriver;
import interfaceadapters.CreateCourseInterfaceAdapters.CreateCourseController;
import interfaceadapters.CreateCourseInterfaceAdapters.CreateCoursePresenter;
import userinterface.GenericProperties;

public class CreateCourseScreen extends JPanel implements ActionListener {
    private final CreateCourseController controller;


    // Text fields for course information
    JTextField CourseName = new JTextField(10);
    JTextField Prerequisite = new JTextField(10);
    JTextField PrerequisiteGrade = new JTextField(10);


    // Text fields for three questions, answers, and points
    JTextField Question1 = new JTextField(10);
    JTextField Answer1 = new JTextField(10);
    JTextField Points1 = new JTextField(10);
    JTextField Question2 = new JTextField(10);
    JTextField Answer2 = new JTextField(10);
    JTextField Points2 = new JTextField(10);
    JTextField Question3 = new JTextField(10);
    JTextField Answer3 = new JTextField(10);
    JTextField Points3 = new JTextField(10);


    // Buttons for course creation and canceling
    JButton create = new JButton("Create");
    JButton cancel = new JButton(("Cancel"));

    // Reference to generic properties
    private final GenericProperties genericProperties;


    /**
     * Constructs a new CreateCourseScreen.
     *
     * @param genericProperties The generic properties of the user interface.
     */
    public CreateCourseScreen(GenericProperties genericProperties) {
        CreateCoursePresenter presenter = new CreateCoursePresenter(new DatabaseDriver());
        this.genericProperties = genericProperties;
        this.controller = presenter.getCreateCourseController();

        // UI layout setup
        JLabel title = new JLabel("Instructor Mode");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Components initialization and layout configuration
        JPanel coursenamePanel = new JPanel();
        coursenamePanel.add(new JLabel("Enter Course Name"));
        coursenamePanel.add(CourseName);

        JPanel prerequisitePanel = new JPanel();
        prerequisitePanel.add(new JLabel("Enter Prerequisite(if no prerequisite, leave it empty.)"));
        prerequisitePanel.add(Prerequisite);

        JPanel prerequisitegradePanel = new JPanel();
        prerequisitegradePanel.add(new JLabel("Enter Prerequisite's Grade(if no prerequisite, leave it empty.)"));
        prerequisitegradePanel.add(PrerequisiteGrade);

        JPanel question1Panel = new JPanel();
        question1Panel.add(new JLabel("Enter Question#1"));
        question1Panel.add(Question1);
        JPanel answer1Panel = new JPanel();
        answer1Panel.add(new JLabel("Enter Answer#1"));
        answer1Panel.add(Answer1);
        JPanel points1Panel = new JPanel();
        points1Panel.add(new JLabel("Enter Points#1"));
        points1Panel.add(Points1);

        JPanel question2Panel = new JPanel();
        question2Panel.add(new JLabel("Enter Question#2"));
        question2Panel.add(Question2);
        JPanel answer2Panel = new JPanel();
        answer2Panel.add(new JLabel("Enter Answer#2"));
        answer2Panel.add(Answer2);
        JPanel points2Panel = new JPanel();
        points2Panel.add(new JLabel("Enter Points#2"));
        points2Panel.add(Points2);

        JPanel question3Panel = new JPanel();
        question3Panel.add(new JLabel("Enter Question#3"));
        question3Panel.add(Question3);
        JPanel answer3Panel = new JPanel();
        answer3Panel.add(new JLabel("Enter Answer#3"));
        answer3Panel.add(Answer3);
        JPanel points3Panel = new JPanel();
        points3Panel.add(new JLabel("Enter Points#3"));
        points3Panel.add(Points3);


        // Attach action listeners to buttons
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);
        create.addActionListener(this);
        cancel.addActionListener(this);

        // Add components to the layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(coursenamePanel);
        this.add(prerequisitePanel);
        this.add(prerequisitegradePanel);
        this.add(question1Panel);
        this.add(answer1Panel);
        this.add(points1Panel);
        this.add(question2Panel);
        this.add(answer2Panel);
        this.add(points2Panel);
        this.add(question3Panel);
        this.add(answer3Panel);
        this.add(points3Panel);
        this.add(buttons);


    }


    /**
     * Handles button click events.
     *
     * @param a The ActionEvent generated by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent a) {
        if ("Cancel".equals(a.getActionCommand())){
            // Handle cancel action
            genericProperties.getCards().show(genericProperties.getScreens(), "main");
        }

        if ("Create".equals(a.getActionCommand())){
            try {
                // Retrieve input values from text fields
                String coursename = CourseName.getText();
                String prereq = Prerequisite.getText();
                String prereqgrade = PrerequisiteGrade.getText();
                ArrayList<String> questions = new ArrayList<>();
                questions.add(Question1.getText());
                questions.add(Question2.getText());
                questions.add(Question3.getText());
                ArrayList<String> answers = new ArrayList<>();
                answers.add(Answer1.getText());
                answers.add(Answer2.getText());
                answers.add(Answer3.getText());
                ArrayList<Integer> points = new ArrayList<>();
                points.add(Integer.valueOf(Points1.getText()));
                points.add(Integer.valueOf(Points2.getText()));
                points.add(Integer.valueOf(Points3.getText()));

                // Call controller to create the course
                String message = controller.createCourse(coursename, prereq, prereqgrade, questions, answers, points);
                JOptionPane.showMessageDialog(this, message);
                genericProperties.getCards().show(genericProperties.getScreens(), "main");
                clearFields();}
            catch ( NumberFormatException e){ JOptionPane.showMessageDialog(this,
                    "Sorry.... something is wrong with what you inputted :(");
            }
            catch (Exception b){JOptionPane.showMessageDialog(this, b.getMessage());
            }
        }
    }

    /**
     * Clears all input fields.
     */
    public void clearFields(){CourseName.setText(null);
    Prerequisite.setText(null);
    PrerequisiteGrade.setText(null);
    Question1.setText(null);
    Question2.setText(null);
    Question3.setText(null);
    Points1.setText(null);
    Points2.setText(null);
    Points3.setText(null);
    Answer1.setText(null);
    Answer2.setText(null);
    Answer3.setText(null);}
}


