package useCases.courseEvaluatorUseCase;

public class EvaluatorDbRequestModel {
    private String studentID;
    private String password;
    private String courseID;
    private float grade;

    public String getStudentID() {
        return studentID;
    }

    public String getPassword() {
        return password;
    }

    public String getCourseID() {
        return courseID;
    }

    public float getGrade() {
        return grade;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
