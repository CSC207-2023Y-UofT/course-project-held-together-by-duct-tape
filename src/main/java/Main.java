import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;

import interfaceadapters.*;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentController;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentPresenter;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentScreen;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentController;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentScreen;

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
        GenericProperties genericProperties = new GenericProperties(screens, cards);

        UserModeScreen mainScreen = new UserModeScreen(genericProperties);
        StudentModeScreen studentModeScreen = new StudentModeScreen(genericProperties);

        // Use Case Screens
        CreateStudentScreen createStudentScreen = new CreateStudentScreen(genericProperties, createStudentController);
        LoginStudentScreen loginScreen = new LoginStudentScreen(genericProperties, loginController);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(genericProperties);

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
