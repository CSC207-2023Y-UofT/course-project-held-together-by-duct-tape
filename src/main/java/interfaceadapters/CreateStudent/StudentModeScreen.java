package interfaceadapters.CreateStudent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
public class StudentModeScreen extends JPanel implements ActionListener{
    private JPanel screens;
    private CardLayout card;

    public StudentModeScreen(JPanel screens, CardLayout card){
        this.card = card;
        this.screens = screens;
        JLabel title = new JLabel("Student Mode");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton login = new JButton("Login");
        JButton create = new JButton("Create New User");
        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(create);
        create.addActionListener(this);
        login.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getActionCommand().equals("Login")){ card.show(screens, "login");}
        if(e.getActionCommand().equals("Create New User")){ card.show(screens, "createStudent");

    }
}}
