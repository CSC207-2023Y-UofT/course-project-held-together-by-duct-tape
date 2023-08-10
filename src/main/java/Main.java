import userinterface.CreateStudentUserInterface.CreateStudentScreen;
import userinterface.GenericProperties;
import userinterface.InstuctorCreateCourseUserInterface.CreateCourseScreen;
import userinterface.LoginStudentUserInterface.LoginStudentScreen;
import userinterface.CourseEnrollmentUserInterface.CourseEnrollmentScreen;
import userinterface.RunCourseUserInterface.RunCourseScreen;
import userinterface.StudentModeScreen;
import userinterface.UserModeScreen;

import javax.swing.*;
import java.awt.*;

/**
 * The `Main` class serves as the entry point for the application and orchestrates the setup and presentation
 * of various user interface screens.
 */
public class Main {
    public static void main(String[] args) {
        // Application set-up
        JFrame application = new JFrame();
        CardLayout cards = new CardLayout();
        JPanel screens = new JPanel(cards);
        application.add(screens);

        // Plug-in screens
        GenericProperties genericProperties = new GenericProperties(screens, cards);
        UserModeScreen mainScreen = new UserModeScreen(genericProperties);
        StudentModeScreen studentModeScreen = new StudentModeScreen(genericProperties);
        CreateStudentScreen createStudentScreen = new CreateStudentScreen(genericProperties);
        LoginStudentScreen loginScreen = new LoginStudentScreen(genericProperties);
        CreateCourseScreen createCourseScreen = new CreateCourseScreen(genericProperties);
        RunCourseScreen courseScreen = new RunCourseScreen(genericProperties);
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(genericProperties, courseScreen);

        // Add screens to the JPanel
        screens.add(mainScreen, "main");
        screens.add(studentModeScreen, "student");
        screens.add(createCourseScreen, "Instructor Mode");
        screens.add(createStudentScreen, "createStudent");
        screens.add(loginScreen, "login");
        screens.add(enrollmentScreen, "enrollment");
        screens.add(courseScreen, "course");

        // Show the main screen by default
        cards.show(screens, "main");


        // Configure application window
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}
