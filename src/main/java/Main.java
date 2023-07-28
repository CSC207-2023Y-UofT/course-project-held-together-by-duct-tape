import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.DbConnection;
import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;

import userinterface.CourseEnrollmentUserInterface.CourseEnrollmentScreen;
import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentController;
import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentController;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentPresenter;
import userinterface.CreateStudentUserInterface.CreateStudentScreen;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentController;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import userinterface.GenericProperties;
import userinterface.LoginStudentUserInterface.LoginStudentScreen;

import usecases.CourseEnrollmentUseCase.CheckPrerequisitesInteractor;
import usecases.CourseEnrollmentUseCase.CourseEnrolmentInteractor;
import usecases.CreateStudentUsecase.CreateStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentInteractor;
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
        DbConnection dbConnection = new DbConnection();
        StudentDbGateway studentDbGateway = new StudentDbGateway(dbConnection);
        SessionDbGateway sessionDbGateway = new SessionDbGateway(dbConnection);
        CourseDbGateway courseDbGateway = new CourseDbGateway(dbConnection);

        // CreateStudent Use Case
        CreateStudentPresenter createStudentPresenter = new CreateStudentPresenter();
        CreateStudentInteractor createStudentInteractor = new CreateStudentInteractor(studentDbGateway, createStudentPresenter);
        CreateStudentController createStudentController = new CreateStudentController(createStudentInteractor);

        // LoginStudent Use Case
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter();
        LoginStudentInteractor loginInteractor = new LoginStudentInteractor(studentDbGateway, sessionDbGateway, loginPresenter);
        LoginStudentController loginController = new LoginStudentController(loginInteractor);

        // CourseEnrollment Use Case
        EnrolmentPresenter enrolmentPresenter = new EnrolmentPresenter(courseDbGateway);
        CheckPrerequisitesInteractor prerequisitesInteractor = new CheckPrerequisitesInteractor(sessionDbGateway);
        CourseEnrolmentInteractor enrolmentInteractor = new CourseEnrolmentInteractor(courseDbGateway, prerequisitesInteractor, sessionDbGateway, enrolmentPresenter);
        EnrolmentController enrolmentController = new EnrolmentController(enrolmentInteractor);

        // Plug-in screens
        GenericProperties genericProperties = new GenericProperties(screens, cards);

        UserModeScreen mainScreen = new UserModeScreen(genericProperties);
        StudentModeScreen studentModeScreen = new StudentModeScreen(genericProperties);

        // Use Case Screens
        CreateStudentScreen createStudentScreen = new CreateStudentScreen(genericProperties, createStudentController);
        LoginStudentScreen loginScreen = new LoginStudentScreen(genericProperties, loginController);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(genericProperties, enrolmentPresenter, enrolmentController);

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
