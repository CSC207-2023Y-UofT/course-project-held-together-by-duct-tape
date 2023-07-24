import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;

import interfaceadapters.CourseEnrollmentScreen;
import interfaceadapters.CreateStudent.CreateStudentController;
import interfaceadapters.CreateStudent.CreateStudentPresenter;
import interfaceadapters.CreateStudent.CreateStudentScreen;
import interfaceadapters.StudentModeScreen;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentController;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentScreen;
import interfaceadapters.MainScreen;

import usecases.CreateStudentUsecase.CreateStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentInteractor;

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
        StudentDbGateway studentDbGateway = new StudentDbGateway();
        SessionDbGateway sessionDbGateway = new SessionDbGateway();
        CourseDbGateway courseDbGateway = new CourseDbGateway();

        // CreateStudent Use Case
        CreateStudentPresenter createStudentPresenter = new CreateStudentPresenter();
        CreateStudentInteractor createStudentInteractor = new CreateStudentInteractor(studentDbGateway, createStudentPresenter);
        CreateStudentController createStudentController = new CreateStudentController(createStudentInteractor);

        // LoginStudent Use Case
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter();
        LoginStudentInteractor loginInteractor = new LoginStudentInteractor(studentDbGateway, sessionDbGateway, loginPresenter);
        LoginStudentController loginController = new LoginStudentController(loginInteractor);

        // Plug-in screens
        MainScreen mainScreen = new MainScreen(screens, cards);
        StudentModeScreen studentModeScreen = new StudentModeScreen(screens, cards);

        // Use Case Screens
        CreateStudentScreen createStudentScreen = new CreateStudentScreen(screens, cards, createStudentController);
        LoginStudentScreen loginScreen = new LoginStudentScreen(screens, cards, loginController);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(screens, cards);

        screens.add(mainScreen, "main");
        screens.add(studentModeScreen, "student");
        screens.add(createStudentScreen, "createStudent");
        screens.add(loginScreen, "login");
        screens.add(enrollmentScreen, "enrollment");

        cards.show(screens, "main");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
