package interfaceadapters;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentModeScreen extends JPanel implements ActionListener{
    private final GenericProperties genericProperties;

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
