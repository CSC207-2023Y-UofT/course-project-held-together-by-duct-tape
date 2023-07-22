package InterfaceAdaptors.CreateStudentInterfaceAdaptors;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

public class CreateStudentScreen extends JPanel implements ActionListener{
    JTextField username = new JTextField(15);
    JTextField repeat = new JTextField(15);
    JButton create = new JButton("Create");

    private CreateStudentController controller;
    // for the following code I used this
    // link: https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/ to figure out how to make
    // the visual aspect of the screen as well as how the actionListener should work.
    public CreateStudentScreen(CreateStudentController controller){ this.controller = controller;
        JLabel title = new JLabel("Create Student");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel user = new JLabel("Enter Student name");
        JLabel rep = new JLabel("Reenter Student name");
        JButton cancel = new JButton("Cancel");
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);
        create.addActionListener(this);
        cancel.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(user);
        this.add(username);
        this.add(rep);
        this.add(repeat);
        this.add(buttons);
    }




    @Override
    public void actionPerformed(ActionEvent e){


        if(e.getSource() == create){
            String student = username.getText();
            String repeated = repeat.getText();
            JOptionPane.showMessageDialog(this, controller.create(student, repeated));}
    }}
