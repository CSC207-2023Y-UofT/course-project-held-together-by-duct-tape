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

    /**
     * Checks if student has completed the course in Session Database.
     * @param studentId the student's Id
     * @param courseId the course Id
     * @return true if student has completed the course, false if not.
     */
    @Override
    public boolean hasCompletedCourse(String studentId, String courseId) {
        return true;
    }

    /**
     * Retrieves the grade for a completed course, from the Session Database.
     * @param studentId the student's Id
     * @param courseId the course Id
     * @return the numeric grade for this course.
     */
    @Override
    public int getCourseGPA(String studentId, String courseId) {
        return 80;
    }

    /**
     * Saves course in Session Database.
     * @param courseId the course Id
     * @param questions the course's questions
     * @return
     */
    @Override
    public void saveCourse(String courseId, List<Question> questions) {
    }

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

}
