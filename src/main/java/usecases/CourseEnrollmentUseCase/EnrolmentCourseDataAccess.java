package usecases.CourseEnrollmentUseCase;

import java.util.List;

/**
 * The interface which separates the course enrollment interactor from the implementation of the course gateway,
 * so that the use case layer does not depend on the gateway.
 */
public interface EnrolmentCourseDataAccess {
    void retrieveCourse(EnrolmentDbRequestModel requestModel);
    List<String> getCourseIDs();
}
