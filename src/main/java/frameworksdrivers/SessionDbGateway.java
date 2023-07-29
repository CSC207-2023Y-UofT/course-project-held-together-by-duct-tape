package frameworksdrivers;

import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEnrollmentUseCase.EnrolmentSessionDataAccess;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.RunCourseUseCase.RunCourseDbRequestModel;
import usecases.RunCourseUseCase.RunCourseSessionDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 * Gateway that accesses and interacts with the Session Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class SessionDbGateway implements LoginSessionDataAccess, EnrolmentSessionDataAccess, RunCourseSessionDataAccess {
    private final Connection connection;
    private final String DATABASE_NAME_STUDENT = "sessionStudent";
    private final String DATABASE_NAME_COURSE = "sessionCourse";

    public SessionDbGateway(DbConnection dbConnection) {
        this.connection = dbConnection.connect();
    }

    /**
     * Checks if student has completed the course in Session Database.
     *
     * @param requestModel the course ID
     * @return true if student has completed the course, false if not.
     */
    @Override
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel) {
        return true;
    }

    /**
     * Retrieves the grade for a completed course, from the Session Database.
     *
     * @param requestModel the course Id
     * @return the numeric grade for this course.
     */
    @Override
    public int getPrerequisiteCourseGPA(EnrolmentDbRequestModel requestModel) {
        return 80;
    }

    /**
     * Saves course in Session Database.
     * @param requestModel the course ID
     */
    @Override
    public void saveCourse(EnrolmentDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<Integer> points = requestModel.getPoints();

            for (int j = 0; j < questions.size(); j++) {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO " + DATABASE_NAME_COURSE + " (CourseID, Question, Answer, Points) VALUES (?, ?, ?, ?)");
                statement.setString(1, requestModel.getCourseID());
                statement.setString(2, questions.get(j));
                statement.setString(3, "");
                statement.setString(4, points.get(j).toString());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
    }

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

    public List<String> getCourseQuestions() {
        List<String> questions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME_COURSE);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
        return questions;
    }

    public void deleteCourseSession() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + DATABASE_NAME_COURSE);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
    }

    @Override
    public void saveAnswers(RunCourseDbRequestModel requestModel) {}
}
