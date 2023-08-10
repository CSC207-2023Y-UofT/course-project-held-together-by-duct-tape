package userinterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `StudentModeScreen` class represents the user interface screen for the student mode options.
 * It allows users to choose between logging in, creating a user, or returning to the main menu.
 */
public class StudentModeScreen extends JPanel implements ActionListener{
    private final GenericProperties genericProperties;


    /**
     * Constructs a new `StudentModeScreen` instance.
     *
     * @param genericProperties The generic properties holder for managing screens and cards.
     */
    public StudentModeScreen(GenericProperties genericProperties){
        this.genericProperties = genericProperties;

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
            genericProperties.getCards().show(genericProperties.getScreens(), "login");
        } else if (e.getActionCommand().equals("Create User")) {
            genericProperties.getCards().show(genericProperties.getScreens(), "createStudent");
        } else {
            genericProperties.getCards().show(genericProperties.getScreens(), "main");
        }
    }
}
