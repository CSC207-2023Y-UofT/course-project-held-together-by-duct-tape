package courseEvaluator.UseCases;

public class EvaluatorDbRequestModel {
    private int StudentId;
    private final String CourseId;
    private  int grade;

    public EvaluatorDbRequestModel(String CourseId) {
        this.StudentId = StudentId;
        this.CourseId = CourseId;
        this.grade = grade;


    } public String getCourseId() {
        return CourseId;

    }public int getStudentId() {
        return StudentId;

    }public int getGrade() {
        return grade;
    }
}
