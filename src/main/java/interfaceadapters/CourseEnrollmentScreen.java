package interfaceadapters;

import frameworksdrivers.CourseDbGateway;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseEnrollmentScreen extends JPanel implements ActionListener {
    private final GenericProperties genericProperties;
    private final CourseEnrollmentPresenter courseEnrollmentPresenter;
    private String courseSelected;

    public CourseEnrollmentScreen(GenericProperties genericProperties, CourseEnrollmentPresenter courseEnrollmentPresenter) {
        this.genericProperties = genericProperties;
        this.courseEnrollmentPresenter = courseEnrollmentPresenter;

        JLabel title = new JLabel("Course Enrollment Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        ButtonGroup radioGroup = new ButtonGroup();

        List<String> courses = courseEnrollmentPresenter.getCourseIDs();

        List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
        for (String course : courses) {
            JRadioButton radio = new JRadioButton(course);
            radio.addActionListener(this);
            radioButtons.add(radio);
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
            // logout use case (delete information from session database)
            genericProperties.getCards().show(genericProperties.getScreens(), "student");
        }

        // try catch
        // courseEnrollmentController.enroll(courseSelected);
    }
}
