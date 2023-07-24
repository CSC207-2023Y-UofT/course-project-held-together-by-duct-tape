package courseEvaluator.UseCases;

public class EvaluatorRequestModel {
    private final String studentId;
    private final String courseId;

    private final int grade;
    public EvaluatorRequestModel(String studentId, String courseId, int grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getCourseId() {
        return courseId;
    }


    public int getGrade() {
        return grade;
    }
}

