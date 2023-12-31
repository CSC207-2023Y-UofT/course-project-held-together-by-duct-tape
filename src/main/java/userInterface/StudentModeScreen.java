package userInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `StudentModeScreen` class represents the user interface screen for the student mode options.
 * It allows users to choose between logging in, creating a user, or returning to the main menu.
 */
public class StudentModeScreen extends JPanel implements ActionListener{

    public StudentModeScreen(){
        JLabel title = new JLabel("Student Mode");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton login = new JButton("Login User");
        JButton create = new JButton("Create User");
        JButton back = new JButton("Return to Main Menu");
        JPanel buttons = new JPanel();
        JPanel buttonMain = new JPanel();

        buttons.add(login);
        buttons.add(create);
        buttonMain.add(back);

        create.addActionListener(this);
        login.addActionListener(this);
        back.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
        this.add(buttonMain);
    }

    /**
     * Handles action events from buttons on the screen.
     *
     * @param e The action event triggered by a button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login User")) {
            Window.cards.show(Window.screens, "login");
        } else if (e.getActionCommand().equals("Create User")) {
            Window.cards.show(Window.screens, "createStudent");
        } else {
            Window.cards.show(Window.screens, "main");
        }
    }
}
