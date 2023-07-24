package courseEvaluator.UseCases;


public class EvaluatorResponseModel {
    private String courseId;
    private int grade;
    public EvaluatorResponseModel(String courseId, int grade) {
        this.courseId = courseId;
        this.grade =  grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public int getGrade() {
        return grade;
    }

}
