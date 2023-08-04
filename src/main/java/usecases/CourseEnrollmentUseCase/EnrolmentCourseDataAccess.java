package usecases.CourseEnrollmentUseCase;

import java.util.List;

public interface EnrolmentCourseDataAccess {
    boolean existsByCourseId(String courseId);
    void retrieveCourse(EnrolmentDbRequestModel requestModel);
    List<String> getCourseIDs();
}
