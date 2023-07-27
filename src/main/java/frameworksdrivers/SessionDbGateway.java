package frameworksdrivers;

import entities.Question;
import usecases.CourseEnrollmentUseCase.EnrolmentDataAccess;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

import java.sql.Connection;
import java.util.List;

/**
 * Gateway that accesses and interacts with the Session Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class SessionDbGateway implements LoginSessionDataAccess, EnrolmentDataAccess {
    private final Connection connection;

    public SessionDbGateway(DbConnection dbConnection) {
        this.connection = dbConnection.connect();
    }

    /**
     * Checks if student has completed the course in Session Database.
     *
     * @param courseId the course ID
     * @return true if student has completed the course, false if not.
     */
    @Override
    public boolean hasCompletedCourse(String courseId) {
        return true;
    }

    /**
     * Retrieves the grade for a completed course, from the Session Database.
     *
     * @param courseId the course Id
     * @return the numeric grade for this course.
     */
    @Override
    public int getCourseGPA(String courseId) {
        return 80;
    }

    /**
     * Saves course in Session Database.
     * @param courseId the course ID
     * @param questions the course's questions
     */
    @Override
    public void saveCourse(String courseId, List<Question> questions) {}

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

}
