package userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserModeScreen extends JPanel implements ActionListener {

    public UserModeScreen() {
        JLabel title = new JLabel("User Mode Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton instructor = new JButton("Instructor Mode");
        JButton student = new JButton("Student Mode");

        JPanel buttons = new JPanel();
        buttons.add(instructor);
        buttons.add(student);

        instructor.addActionListener(this);
        student.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Event: " + event.getActionCommand());

        if (event.getActionCommand().equals("Student Mode")) {
            Window.cards.show(Window.screens, "student");
        } else if (event.getActionCommand().equals("Instructor Mode")) {
            // GO TO INSTRUCTOR SCREEN
            return ;
        }
    }
}
