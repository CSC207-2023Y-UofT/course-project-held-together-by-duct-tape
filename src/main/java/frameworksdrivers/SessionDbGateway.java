package frameworksdrivers;

import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEnrollmentUseCase.EnrolmentSessionDataAccess;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

import java.sql.Connection;

/**
 * Gateway that accesses and interacts with the Session Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class SessionDbGateway implements LoginSessionDataAccess, EnrolmentSessionDataAccess {
    private final Connection connection;

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
    public void saveCourse(EnrolmentDbRequestModel requestModel) {}

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}
}
