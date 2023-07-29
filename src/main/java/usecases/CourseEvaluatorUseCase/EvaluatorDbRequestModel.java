package usecases.CourseEvaluatorUseCase;

public class EvaluatorDbRequestModel {
    private final String studentID;
    private final String courseID;
    private final float grade;

    public EvaluatorDbRequestModel(String studentID, String courseID, float grade) {
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

    public float getGrade() {
        return grade;
    }
}
