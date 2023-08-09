package usecases.courseEvaluatorUseCase;


public class EvaluatorResponseModel {
    private final String courseId;
    private final float percentage;

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
