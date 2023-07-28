package userinterface.RunCourseUserInterface;

import interfaceadapters.RunCourseInterfaceAdapters.RunCourseController;
import interfaceadapters.RunCourseInterfaceAdapters.RunCoursePresenter;
import userinterface.GenericProperties;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunCourseScreen extends JPanel implements ActionListener {
    private String question1;
    private final JTextField answer1 = new JTextField(25);
    private String question2;
    private final JTextField answer2 = new JTextField(25);
    private final GenericProperties genericProperties;
    private final RunCourseController controller;
    private final RunCoursePresenter presenter;

    public RunCourseScreen(GenericProperties genericProperties, RunCourseController courseController, RunCoursePresenter presenter) {
        this.genericProperties = genericProperties;
        this.controller = courseController;
        this.presenter = presenter;

        JLabel title = new JLabel("Course Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
    }

    public void renderQuestions() {
        List<String> questions = presenter.getCourseQuestions();
        this.question1 = questions.get(0);
        this.question2 = questions.get(1);

        JPanel question1Panel = new JPanel();
        question1Panel.add(new JLabel(question1));
        question1Panel.add(answer1);
        JPanel question2Panel = new JPanel();
        question2Panel.add(new JLabel(question2));
        question2Panel.add(answer2);

        JButton save = new JButton("Save Course");
        JButton evaluate = new JButton("Evaluate");
        JButton unenroll = new JButton("Unenroll");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(unenroll);

        JPanel button = new JPanel();
        buttons.add(evaluate);

        save.addActionListener(this);
        unenroll.addActionListener(this);
        evaluate.addActionListener(this);

        this.add(question1Panel);
        this.add(question2Panel);
        this.add(buttons);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Event " + event.getActionCommand());

        if (event.getActionCommand().equals("Unenroll")) {
            presenter.deleteCourseSession();
            genericProperties.getCards().show(genericProperties.getScreens(), "enrollment");
        }


    }
}
