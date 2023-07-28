package userinterface.CreateStudentUserInterface;

import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentController;
import userinterface.GenericProperties;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class CreateStudentScreen extends JPanel implements ActionListener{
    JTextField username = new JTextField(10);
    JTextField repeat = new JTextField(10);
    JTextField password = new JTextField(10);
    JButton create = new JButton("Create");
    JButton cancel = new JButton(("Cancel"));
    private final GenericProperties genericProperties;

    /**This is the create student screen that is displayed when a user wants to create a new student*/
    private final CreateStudentController controller;
    // for the following code I used this
    // link: https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/ to figure out how to make
    // the visual aspect of the screen as well as how the actionListener should work.
    public CreateStudentScreen(GenericProperties genericProperties, CreateStudentController controller){
        this.genericProperties = genericProperties;

        this.controller = controller;
        JLabel title = new JLabel("Create Student");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Enter Username"));
        usernamePanel.add(username);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Enter Password"));
        passwordPanel.add(password);
        JPanel repeatPasswordPanel = new JPanel();
        repeatPasswordPanel.add(new JLabel("Reenter Username"));
        repeatPasswordPanel.add(repeat);
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);
        create.addActionListener(this);
        cancel.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(repeatPasswordPanel);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Create")) {
            String student = username.getText();
            String repeated = repeat.getText();
            String pass = password.getText();
            JOptionPane.showMessageDialog(this, controller.create(student,repeated, pass));
            genericProperties.getCards().show(genericProperties.getScreens(), "student");
        } else if (e.getActionCommand().equals("Cancel")) {
            genericProperties.getCards().show(genericProperties.getScreens(), "student");
        }
    }
}
