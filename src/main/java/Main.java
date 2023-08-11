import userinterface.Window;
import userinterface.UserModeScreen;
import userinterface.StudentModeScreen;
import userinterface.createCourseUserInterface.CreateCourseScreen;
import userinterface.createStudentUserInterface.CreateStudentScreen;
import userinterface.loginStudentUserInterface.LoginStudentScreen;
import userinterface.courseEnrollmentUserInterface.CourseEnrollmentScreen;
import userinterface.runCourseUserInterface.RunCourseScreen;

/**
 * The `Main` class serves as the entry point for the application and orchestrates the setup and presentation
 * of various user interface screens.
 */
public class Main {
    public static void main(String[] args) {
        // Application set-up
        Window window = new Window();

        // Plug-in screens
        UserModeScreen mainScreen = new UserModeScreen();
        StudentModeScreen studentModeScreen = new StudentModeScreen();
        CreateStudentScreen createStudentScreen = new CreateStudentScreen();
        LoginStudentScreen loginScreen = new LoginStudentScreen();
        CreateCourseScreen createCourseScreen = new CreateCourseScreen();
        RunCourseScreen courseScreen = new RunCourseScreen();
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(courseScreen);

        window.addScreen(mainScreen, "main");
        window.addScreen(studentModeScreen, "student");
        window.addScreen(createStudentScreen, "createStudent");
        window.addScreen(loginScreen, "login");
        window.addScreen(enrollmentScreen, "enrollment");
        window.addScreen(courseScreen, "course");
        window.addScreen(createCourseScreen, "instructor");

        window.render();
    }
}
