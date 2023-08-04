package userinterface.RunCourseUserInterface;

import frameworksdrivers.DatabaseDriver;
import interfaceadapters.CourseEvaluatorInterfaceAdapters.EvaluatorController;
import interfaceadapters.CourseEvaluatorInterfaceAdapters.EvaluatorPresenter;
import interfaceadapters.RunCourseInterfaceAdapters.RunCourseController;
import interfaceadapters.RunCourseInterfaceAdapters.RunCoursePresenter;
import userinterface.GenericProperties;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunCourseScreen extends JPanel implements ActionListener {
    private List<String> questions = new ArrayList<>();
    private List<JTextField> answers = new ArrayList<>();
    private final GenericProperties genericProperties;
    private final RunCourseController controller;
    private final RunCoursePresenter presenter;
    private final EvaluatorController evaluatorController;

    public RunCourseScreen(GenericProperties genericProperties, EvaluatorPresenter evaluatorPresenter) {
        DatabaseDriver databaseDriver = new DatabaseDriver();
        RunCoursePresenter coursePresenter = new RunCoursePresenter(databaseDriver);
        this.genericProperties = genericProperties;
        this.controller = coursePresenter.getCourseController();
        this.presenter = coursePresenter;
        this.evaluatorController = evaluatorPresenter.getEvaluatorController();

        JLabel title = new JLabel("Course Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
    }

    public void renderQuestions() {
        List<String> questionsCourse = presenter.getCourseQuestions();
        setUpAnswers(questionsCourse.size());

        for (int j = 0; j < questionsCourse.size(); j++) {
            questions.add(questionsCourse.get(j));
            JPanel questionPanel = new JPanel();
            questionPanel.add(new JLabel(questions.get(j)));

            JPanel answerPanel = new JPanel();
            answerPanel.add(answers.get(j));

            this.add(questionPanel);
            this.add(answerPanel);
        }

        JButton save = new JButton("Evaluate Course");
        JButton unenroll = new JButton("Unenroll");

        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(unenroll);

        save.addActionListener(this);
        unenroll.addActionListener(this);

        this.add(buttons);
    }

    public void setUpAnswers(int size) {
        for (int j = 0; j < size; j++) {
            JTextField answer = new JTextField(25);
            answers.add(answer);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Event " + event.getActionCommand());

        if (event.getActionCommand().equals("Evaluate Course")) {
            List<String> answersCourse = formatAnswers();
            JOptionPane.showMessageDialog(this, controller.runCourse(questions, answersCourse));
            JOptionPane.showMessageDialog(this, evaluatorController.evaluateCourse());
        } else if (event.getActionCommand().equals("Unenroll")) {
            presenter.deleteCourseSession();
        }

        presenter.deleteCourseSession();
        genericProperties.getCards().show(genericProperties.getScreens(), "enrollment");
        clearFields();
    }

    public List<String> formatAnswers() {
        List<String> answerList = new ArrayList<>();
        for (JTextField answer : answers) {
            answerList.add(answer.getText());
        }
        return answerList;
    }

    public void clearFields() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();

        Component[] components = this.getComponents();

        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                this.remove(component);
            }
        }
    }
}
