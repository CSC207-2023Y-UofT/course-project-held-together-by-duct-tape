package usecases.CourseEnrollmentUseCase;

import java.util.List;

public interface EnrolmentCourseDataAccess {
    public boolean existsByCourseId(String courseId);
    public void retrieveCourse(EnrolmentDbRequestModel requestModel);
    List<String> getCourseIDs();
}
