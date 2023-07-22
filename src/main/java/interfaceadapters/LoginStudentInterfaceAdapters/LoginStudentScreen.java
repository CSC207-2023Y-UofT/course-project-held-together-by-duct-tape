package interfaceadapters.LoginStudentInterfaceAdapters;

import usecases.LoginStudentUseCase.LoginStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class LoginStudentScreen extends JPanel implements ActionListener {
    private JTextField username = new JTextField(10);
    private JTextField repeatUsername = new JTextField(10);
    private final LoginStudentInteractor interactor;
    private JPanel screens;
    private CardLayout cards;

    public LoginStudentScreen(JPanel screens, CardLayout cards, LoginStudentInteractor loginInteractor) {
        this.interactor = loginInteractor;
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

        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username.getText(), repeatUsername.getText());

        try {
            if (Objects.equals(command, "Login")) {
                interactor.login(requestModel);
                JOptionPane.showMessageDialog(this, username.getText() + " successful login");
                clearFields();
                cards.show(screens, "enrollment");
            } else {
                clearFields();
                cards.show(screens, "main");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void clearFields() {
        username.setText(null);
        repeatUsername.setText(null);
    }
}
