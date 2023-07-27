package usecases.CourseEnrollmentUseCase;

import java.util.List;
/**
 * Data structure which packages the course ID and the questions to be displayed on the screen.
 */
public class EnrolmentResponseModel {
    private final String courseId;

    public EnrolmentResponseModel(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
