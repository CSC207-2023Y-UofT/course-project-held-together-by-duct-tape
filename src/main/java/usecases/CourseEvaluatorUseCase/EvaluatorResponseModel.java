package usecases.CourseEvaluatorUseCase;


public class EvaluatorResponseModel {
    private String courseId;
    private float percentage;

    public EvaluatorResponseModel(String courseId, float percentage) {
        this.courseId = courseId;
        this.percentage = percentage;

    }

    public String getCourseId() {
        return courseId;
    }

    public float getPercentage(){
        return percentage;
    }

}
