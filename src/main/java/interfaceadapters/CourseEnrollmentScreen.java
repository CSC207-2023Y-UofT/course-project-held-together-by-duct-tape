package interfaceadapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseEnrollmentScreen extends JPanel implements ActionListener {

    private JPanel screens;
    private CardLayout cards;

    public CourseEnrollmentScreen(JPanel screens, CardLayout cards) {
        this.screens = screens;
        this.cards = cards;

        JLabel title = new JLabel("Course Enrollment Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton enroll = new JButton("Enroll");
        JButton logout = new JButton("Logout");

        JPanel buttons = new JPanel();
        buttons.add(enroll);
        buttons.add(logout);

        enroll.addActionListener(this);
        logout.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Event " + event.getActionCommand());

        if (event.getActionCommand().equals("Logout")) {
            cards.show(screens, "login");
        }
    }
}