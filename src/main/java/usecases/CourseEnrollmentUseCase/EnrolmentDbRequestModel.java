package usecases.CourseEnrollmentUseCase;

public class EnrolmentDbRequestModel {
    private final String courseId;
    public EnrolmentDbRequestModel(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
