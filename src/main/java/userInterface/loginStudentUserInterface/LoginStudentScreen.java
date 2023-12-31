package userInterface.loginStudentUserInterface;

import frameworksDrivers.DatabaseDriver;
import frameworksDrivers.Driver;
import interfaceAdapters.loginStudentInterfaceAdapters.LoginStudentPresenter;
import userInterface.Window;
import interfaceAdapters.loginStudentInterfaceAdapters.LoginStudentController;
import userInterface.courseEnrollmentUserInterface.CourseEnrollmentScreen;

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
    private final LoginStudentController controller;
    private final CourseEnrollmentScreen courseEnrollmentScreen;

    public LoginStudentScreen(CourseEnrollmentScreen courseEnrollmentScreen) {
        Driver databaseDriver = new DatabaseDriver();
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter(databaseDriver);
        this.controller = loginPresenter.getLoginController();
        this.courseEnrollmentScreen = courseEnrollmentScreen;

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
            Window.cards.show(Window.screens, "student");
            return ;
        }

        try {
            String passcode = new String(password.getPassword());
            controller.login(username.getText(), passcode);
            JOptionPane.showMessageDialog(this, username.getText() + " successful login");
            courseEnrollmentScreen.renderCourses();
            Window.cards.show(Window.screens, "enrollment");
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
