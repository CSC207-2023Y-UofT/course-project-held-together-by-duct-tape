package usecases.CourseEvaluatorUseCase;

// question do i need a db request model, i dont use is ?
//not useful since i dont use it anywhere
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
