package userInterface.runCourseUserInterface;

import frameworksDrivers.DatabaseDriver;
import interfaceAdapters.courseEvaluatorInterfaceAdapters.EvaluatorController;
import interfaceAdapters.courseEvaluatorInterfaceAdapters.EvaluatorPresenter;
import interfaceAdapters.runCourseInterfaceAdapters.RunCourseController;
import interfaceAdapters.runCourseInterfaceAdapters.RunCoursePresenter;
import userInterface.Window;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunCourseScreen extends JPanel implements ActionListener {
    private List<String> questions = new ArrayList<>();
    private List<JTextField> answers = new ArrayList<>();
    private final RunCourseController controller;
    private final RunCoursePresenter presenter;
    private final EvaluatorController evaluatorController;

    public RunCourseScreen() {
        DatabaseDriver databaseDriver = new DatabaseDriver();
        this.presenter = new RunCoursePresenter(databaseDriver);
        this.controller = presenter.getCourseController();
        EvaluatorPresenter evaluatorPresenter = new EvaluatorPresenter(databaseDriver);
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
            String message = controller.runCourse(questions, answersCourse);
            JOptionPane.showMessageDialog(this, message);
            if (!message.equals("Answers can not be empty.")) {
                JOptionPane.showMessageDialog(this, evaluatorController.evaluateCourse());
            }
        } else if (event.getActionCommand().equals("Unenroll")) {
            presenter.deleteCourseSession();
        }

        presenter.deleteCourseSession();
        Window.cards.show(Window.screens, "login");
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
