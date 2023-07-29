import frameworksdrivers.DatabaseDriver;

import interfaceadapters.CourseEvaluator.EvaluatorPresenter;
import interfaceadapters.RunCourseInterfaceAdapters.RunCoursePresenter;
import userinterface.CourseEnrollmentUserInterface.CourseEnrollmentScreen;
import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;

import userinterface.CreateStudentUserInterface.CreateStudentScreen;
import userinterface.GenericProperties;
import userinterface.LoginStudentUserInterface.LoginStudentScreen;
import userinterface.RunCourseUserInterface.RunCourseScreen;
import userinterface.StudentModeScreen;
import userinterface.UserModeScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Application set-up
        JFrame application = new JFrame();
        CardLayout cards = new CardLayout();
        JPanel screens = new JPanel(cards);
        application.add(screens);

        // Components
        DatabaseDriver databaseDriver = new DatabaseDriver();

        // Presenters
        CreateStudentPresenter createStudentPresenter = new CreateStudentPresenter(databaseDriver);
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter(databaseDriver);
        EnrolmentPresenter enrolmentPresenter = new EnrolmentPresenter(databaseDriver);
        RunCoursePresenter coursePresenter = new RunCoursePresenter(databaseDriver);
        EvaluatorPresenter evaluatorPresenter = new EvaluatorPresenter(databaseDriver);

        // Plug-in screens
        GenericProperties genericProperties = new GenericProperties(screens, cards);
        UserModeScreen mainScreen = new UserModeScreen(genericProperties);
        StudentModeScreen studentModeScreen = new StudentModeScreen(genericProperties);
        CreateStudentScreen createStudentScreen = new CreateStudentScreen(genericProperties, createStudentPresenter);
        LoginStudentScreen loginScreen = new LoginStudentScreen(genericProperties, loginPresenter);
        RunCourseScreen courseScreen = new RunCourseScreen(genericProperties, coursePresenter, evaluatorPresenter);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(genericProperties, enrolmentPresenter, courseScreen);

        screens.add(mainScreen, "main");
        screens.add(studentModeScreen, "student");
        screens.add(createStudentScreen, "createStudent");
        screens.add(loginScreen, "login");
        screens.add(enrollmentScreen, "enrollment");
        screens.add(courseScreen, "course");

        cards.show(screens, "main");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
