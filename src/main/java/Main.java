import userinterface.Application;
import userinterface.CourseEnrollmentUserInterface.CourseEnrollmentScreen;

import userinterface.CreateStudentUserInterface.CreateStudentScreen;
import userinterface.LoginStudentUserInterface.LoginStudentScreen;
import userinterface.RunCourseUserInterface.RunCourseScreen;
import userinterface.StudentModeScreen;
import userinterface.UserModeScreen;

public class Main {
    public static void main(String[] args) {
        // Application set-up
        Application application = new Application();

        // Plug-in screens
        UserModeScreen mainScreen = new UserModeScreen();
        StudentModeScreen studentModeScreen = new StudentModeScreen();
        CreateStudentScreen createStudentScreen = new CreateStudentScreen();
        LoginStudentScreen loginScreen = new LoginStudentScreen();
        RunCourseScreen courseScreen = new RunCourseScreen();
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(courseScreen);

        application.addScreen(mainScreen, "main");
        application.addScreen(studentModeScreen, "student");
        application.addScreen(createStudentScreen, "createStudent");
        application.addScreen(loginScreen, "login");
        application.addScreen(enrollmentScreen, "enrollment");
        application.addScreen(courseScreen, "course");

        application.render();
    }
}
