package usecases.CourseEnrollmentUseCase;

public class EnrolmentRequestModel {
    private String courseId;

    public EnrolmentRequestModel(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
