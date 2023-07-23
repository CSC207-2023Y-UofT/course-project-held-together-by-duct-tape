package CourseEnrolmentUseCase;

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
    public Student getStudent(String id) {
        //retrieve student with this id
    }
    public String getCourseId() {
        return courseId;
    }
}
