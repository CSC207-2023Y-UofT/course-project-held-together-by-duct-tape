package userinterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login User")) {
            Application.cards.show(Application.screens, "login");
        } else if (e.getActionCommand().equals("Create User")) {
            Application.cards.show(Application.screens, "createStudent");
        } else {
            Application.cards.show(Application.screens, "main");
        }
    }
}
