package interfaceadapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JPanel implements ActionListener {
    private CardLayout cards;
    private JPanel screens;
    public MainScreen(JPanel screens, CardLayout cards) {
        this.cards = cards;
        this.screens = screens;

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
            cards.show(screens, "student");
        }
    }
}
