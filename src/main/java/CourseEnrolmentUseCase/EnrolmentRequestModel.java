package UseCases;

public class EnrolmentRequestModel {
    private final String studentId;
    private String courseId;
    public EnrolmentRequestModel(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }
}
