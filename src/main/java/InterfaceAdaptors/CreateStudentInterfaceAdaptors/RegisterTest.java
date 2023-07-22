package InterfaceAdaptors.CreateStudentInterfaceAdaptors;

import CreateStudentUsecase.CreateStudentDataAccess;
import CreateStudentUsecase.CreateStudentInputBoundary;
import CreateStudentUsecase.CreateStudentInteractor;
import CreateStudentUsecase.CreateStudentOutputBoundary;
import mocks.DummyDataGateway;

import javax.swing.*;
import java.awt.*;


public class RegisterTest {// this is just to see if my layout is working

    public static void main(String[] args) throws Exception{
        JFrame application = new JFrame("CreateStudentExample");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        CreateStudentDataAccess d = new DummyDataGateway();
        CreateStudentOutputBoundary p = new CreateStudentPresenter();
        CreateStudentInputBoundary i = new CreateStudentInteractor(d,p);
        CreateStudentController f = new CreateStudentController(i);
        CreateStudentScreen c = new CreateStudentScreen(f);
        screens.add(c, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);

    }
}
