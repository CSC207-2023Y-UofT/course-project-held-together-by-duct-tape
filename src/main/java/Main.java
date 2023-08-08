import userinterface.Window;
import userinterface.CourseEnrollmentUserInterface.CourseEnrollmentScreen;

import userinterface.CreateStudentUserInterface.CreateStudentScreen;
import userinterface.LoginStudentUserInterface.LoginStudentScreen;
import userinterface.RunCourseUserInterface.RunCourseScreen;
import userinterface.StudentModeScreen;
import userinterface.UserModeScreen;

public class Main {
    public static void main(String[] args) {
        // Application set-up
        Window window = new Window();

        // Plug-in screens
        UserModeScreen mainScreen = new UserModeScreen();
        StudentModeScreen studentModeScreen = new StudentModeScreen();
        CreateStudentScreen createStudentScreen = new CreateStudentScreen();
        LoginStudentScreen loginScreen = new LoginStudentScreen();
        RunCourseScreen courseScreen = new RunCourseScreen();
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(courseScreen);

        window.addScreen(mainScreen, "main");
        window.addScreen(studentModeScreen, "student");
        window.addScreen(createStudentScreen, "createStudent");
        window.addScreen(loginScreen, "login");
        window.addScreen(enrollmentScreen, "enrollment");
        window.addScreen(courseScreen, "course");

        window.render();
    }
}
