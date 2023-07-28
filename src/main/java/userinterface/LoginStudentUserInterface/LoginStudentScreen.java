package userinterface.LoginStudentUserInterface;

import userinterface.GenericProperties;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Screen that handles logging an existing student. The screen has two text fields, one for the username, and another
 * for the repeatUsername.
 */
public class LoginStudentScreen extends JPanel implements ActionListener {
    private final JTextField username = new JTextField(10);
    private final JPasswordField password = new JPasswordField(10);
    private final GenericProperties genericProperties;
    private final LoginStudentController controller;

    public LoginStudentScreen(GenericProperties genericProperties, LoginStudentController loginController) {
        this.genericProperties = genericProperties;
        this.controller = loginController;

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username"));
        usernamePanel.add(username);
        JPanel repeatUsernamePanel = new JPanel();
        repeatUsernamePanel.add(new JLabel("Password"));
        repeatUsernamePanel.add(password);

        JButton login = new JButton("Login");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(cancel);

        login.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernamePanel);
        this.add(repeatUsernamePanel);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Cancel")) {
            genericProperties.getCards().show(genericProperties.getScreens(), "student");
            return ;
        }

        try {
            String passcode = new String(password.getPassword());
           controller.login(username.getText(), passcode);
           JOptionPane.showMessageDialog(this, username.getText() + " successful login");
            genericProperties.getCards().show(genericProperties.getScreens(), "enrollment");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            clearFields();
        }
    }

    public void clearFields() {
        username.setText(null);
        password.setText(null);
    }
}
