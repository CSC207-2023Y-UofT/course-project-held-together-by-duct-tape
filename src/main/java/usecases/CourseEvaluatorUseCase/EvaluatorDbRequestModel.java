package usecases.CourseEvaluatorUseCase;

public class EvaluatorDbRequestModel {
    private String studentID;
    private String courseID;
    private int grade;

    public EvaluatorDbRequestModel(String studentID, String courseID, int grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getGrade() {
        return grade;
    }
}
