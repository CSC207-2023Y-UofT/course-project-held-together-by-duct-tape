package interfaceadapters.LoginStudentInterfaceAdapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginStudentScreen extends JPanel implements ActionListener {
    private final JTextField username = new JTextField(10);
    private final JTextField repeatUsername = new JTextField(10);
    private final LoginStudentController controller;
    private final JPanel screens;
    private final CardLayout cards;

    public LoginStudentScreen(JPanel screens, CardLayout cards, LoginStudentController loginController) {
        this.controller = loginController;
        this.screens = screens;
        this.cards = cards;

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username"));
        usernamePanel.add(username);
        JPanel repeatUsernamePanel = new JPanel();
        repeatUsernamePanel.add(new JLabel("Repeat Username"));
        repeatUsernamePanel.add(repeatUsername);

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
            cards.show(screens, "student");
            return ;
        }

        try {
           controller.login(username.getText(), repeatUsername.getText());
           JOptionPane.showMessageDialog(this, username.getText() + " successful login");
           cards.show(screens, "enrollment");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            clearFields();
        }
    }

    public void clearFields() {
        username.setText(null);
        repeatUsername.setText(null);
    }
}
