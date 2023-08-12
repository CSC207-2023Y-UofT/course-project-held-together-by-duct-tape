package userInterface.courseEnrollmentUserInterface;

import frameworksDrivers.DatabaseDriver;
import interfaceAdapters.courseEnrollmentInterfaceAdapters.EnrolmentController;
import interfaceAdapters.courseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import userInterface.Window;
import userInterface.runCourseUserInterface.RunCourseScreen;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseEnrollmentScreen extends JPanel implements ActionListener {
    private final EnrolmentPresenter enrollmentPresenter;
    private final EnrolmentController enrollmentController;
    private final RunCourseScreen courseScreen;
    private String courseSelected;

    public CourseEnrollmentScreen(RunCourseScreen courseScreen) {
        DatabaseDriver driver = new DatabaseDriver();
        this.enrollmentPresenter = new EnrolmentPresenter(driver);
        this.enrollmentController = enrollmentPresenter.getEnrolmentController();
        this.courseScreen = courseScreen;

        JLabel title = new JLabel("Course Enrollment Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
    }

    public void renderCourses() {
        clearFields();
        ButtonGroup radioGroup = new ButtonGroup();

        List<String> courses = enrollmentPresenter.getCourseIDs();

        for (String course : courses) {
            JRadioButton radio = new JRadioButton(course);
            radio.addActionListener(this);
            radioGroup.add(radio);
            this.add(radio);
        }

        JButton enroll = new JButton("Enroll");
        JButton logout = new JButton("Logout");

        JPanel buttons = new JPanel();
        buttons.add(enroll);
        buttons.add(logout);

        enroll.addActionListener(this);
        logout.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(buttons);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Event " + event.getActionCommand());

        if (!(event.getActionCommand().equals("Enroll") || event.getActionCommand().equals("Logout"))) {
            this.courseSelected = event.getActionCommand();
            return ;
        }

        if (event.getActionCommand().equals("Logout")) {
            enrollmentPresenter.deleteStudentSession();
            Window.cards.show(Window.screens, "student");
            return ;
        }

        try {
             enrollmentController.enrol(courseSelected);
             JOptionPane.showMessageDialog(this, "Successful enroll in " + courseSelected);
             courseScreen.renderQuestions();
             Window.cards.show(Window.screens, "course");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            enrollmentPresenter.deleteCourseSession();
        }
    }

    public void clearFields() {
        Component[] components = this.getComponents();

        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                this.remove(component);
            }
        }
    }
}
