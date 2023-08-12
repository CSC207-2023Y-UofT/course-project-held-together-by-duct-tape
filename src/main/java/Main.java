import userInterface.Window;
import userInterface.UserModeScreen;
import userInterface.StudentModeScreen;
import userInterface.createCourseUserInterface.CreateCourseScreen;
import userInterface.createStudentUserInterface.CreateStudentScreen;
import userInterface.loginStudentUserInterface.LoginStudentScreen;
import userInterface.courseEnrollmentUserInterface.CourseEnrollmentScreen;
import userInterface.runCourseUserInterface.RunCourseScreen;

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
        CreateCourseScreen createCourseScreen = new CreateCourseScreen();
        RunCourseScreen courseScreen = new RunCourseScreen();
        CourseEnrollmentScreen enrollmentScreen = new CourseEnrollmentScreen(courseScreen);
        LoginStudentScreen loginScreen = new LoginStudentScreen(enrollmentScreen);

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
