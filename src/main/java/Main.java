import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;
import interfaceadapters.LoginStudent.LoginStudentPresenter;
import interfaceadapters.LoginStudent.LoginStudentScreen;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentInputBoundary;
import usecases.LoginStudentUseCase.LoginStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

//        // Application
//        JFrame application = new JFrame();
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//        // Login Use Case
//        SessionDbGateway sessionDbGateway = new SessionDbGateway();
//        StudentDbGateway studentDbGateway = new StudentDbGateway();
//        LoginStudentOutputBoundary loginPresenter = new LoginStudentPresenter();
//        LoginStudentInputBoundary loginInteractor = new
//                LoginStudentInteractor(studentDbGateway, sessionDbGateway, loginPresenter);
//
//        // Screen
//        LoginStudentScreen loginScreen = new LoginStudentScreen();
//        screens.add(loginScreen);
//        cardLayout.show(screens, "login");
//        application.pack();
//        application.setVisible(true);
    }
}
