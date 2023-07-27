package frameworksdrivers;


import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

import entities.Question;
import usecases.CourseEnrollmentUseCase.EnrolmentDataAccess;

import java.util.List;


/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class SessionDbGateway implements EnrolmentDataAccess, LoginSessionDataAccess {

    @Override
    public boolean hasCompletedCourse(String studentId, String courseId) {
        return true;
    }

    @Override
    public int getCourseGPA(String studentId, String courseId) {
        return 80;
    }

    @Override
    public void saveCourse(String studentId, List<Question> questions) {

    }

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

}
