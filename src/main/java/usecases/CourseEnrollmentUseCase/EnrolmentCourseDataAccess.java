package usecases.CourseEnrollmentUseCase;

import java.util.List;

public interface EnrolmentCourseDataAccess {
    void retrieveCourse(EnrolmentDbRequestModel requestModel);
    List<String> getCourseIDs();
}
