package usecases.CourseEvaluator;

public class EvaluatorDbRequestModel {
    private String studentId;
    private final String CourseId;
    private  int grade;

    public EvaluatorDbRequestModel(String studentId, String CourseId, int grade) {
        this.studentId = studentId;
        this.CourseId = CourseId;
        this.grade = grade;


    } public String getCourseId() {
        return CourseId;

    }public String getStudentId() {
        return studentId;

    }public int getGrade() {
        return grade;
    }
}
