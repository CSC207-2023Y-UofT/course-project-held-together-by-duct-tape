package usecases.CourseEnrollmentUseCase;

import java.util.List;

/**
 * The interface which separates the course enrollment interactor from the implementation of the course gateway,
 * so that the use case layer does not depend on the gateway.
 */
public interface EnrolmentCourseDataAccess {

    /**
     * Checks if ID exists in Course Database.
     *
     * @param courseId the course ID
     * @return true if the course is in Course Database, false if not.
     */
    boolean existsByCourseId(String courseId);

    /**
     * Retrieves course from Course Database.
     *
     * @param requestModel the course ID
     */
    void retrieveCourse(EnrolmentDbRequestModel requestModel);

    /**
     * Method that returns a list of all the courses offered.
     *
     * @return List of Strings where each String represents a courseID.
     */
    List<String> getCourseIDs();
}
