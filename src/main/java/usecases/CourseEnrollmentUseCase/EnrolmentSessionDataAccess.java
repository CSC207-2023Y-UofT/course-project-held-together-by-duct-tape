package usecases.CourseEnrollmentUseCase;

/**
 * The interface which separates the enrollment interactors from the implementation of the session gateway, so that
 * the use case layer does not depend on the gateway.
 */
public interface EnrolmentSessionDataAccess {
    boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel);
    void saveCourse(EnrolmentDbRequestModel requestModel);
    void deleteCourseSession();
    void deleteStudentSession();
}
