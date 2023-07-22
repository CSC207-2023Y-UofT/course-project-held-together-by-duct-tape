import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;
import interfaceadapters.CourseEnrollmentScreen;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentScreen;
import interfaceadapters.MainScreen;
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

        LoginStudentPresenter loginPresenter = new LoginStudentPresenter();
        StudentDbGateway studentDbGateway = new StudentDbGateway();
        SessionDbGateway sessionDbGateway = new SessionDbGateway();

        LoginStudentInteractor loginInteractor = new LoginStudentInteractor(studentDbGateway, sessionDbGateway, loginPresenter);
        // No controller for now

        // Plug-in screens

        MainScreen mainScreen = new MainScreen(screens, cards);
        LoginStudentScreen loginScreen = new LoginStudentScreen(screens, cards, loginInteractor);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(screens, cards);

        screens.add(mainScreen, "main");
        screens.add(loginScreen, "login");
        screens.add(enrollmentScreen, "enrollment");

        cards.show(screens, "main");

        application.pack();
        application.setVisible(true);

    }
}
