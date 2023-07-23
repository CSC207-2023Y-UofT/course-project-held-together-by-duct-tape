package interfaceadapters.CreateStudent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class CreateStudentScreen extends JPanel implements ActionListener{
    JTextField username = new JTextField(10);
    JTextField repeat = new JTextField(10);
    JButton create = new JButton("Create");

    JButton cancel = new JButton(("Cancel"));
    JPanel screens;
    CardLayout cards;

    /**This is the create student screen that is displayed when a user wants to create a new student*/
    private CreateStudentController controller;
    // for the following code I used this
    // link: https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/ to figure out how to make
    // the visual aspect of the screen as well as how the actionListener should work.
    public CreateStudentScreen(JPanel screens, CardLayout cards, CreateStudentController controller){
        this.cards = cards;
        this.screens = screens;
        this.controller = controller;
        JLabel title = new JLabel("Create Student");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Enter Username"));
        usernamePanel.add(username);
        JPanel repeatUsernamePanel = new JPanel();
        repeatUsernamePanel.add(new JLabel("Reenter Username"));
        repeatUsernamePanel.add(repeat);
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);
        create.addActionListener(this);
        cancel.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernamePanel);
        this.add(repeatUsernamePanel);
        this.add(buttons);
    }




    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == create){
            String student = username.getText();
            String repeated = repeat.getText();
            JOptionPane.showMessageDialog(this, controller.create(student, repeated));}
        if (e.getSource() == cancel){
            cards.show(screens, "student");
        }
    }}
