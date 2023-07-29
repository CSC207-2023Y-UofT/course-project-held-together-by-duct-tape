package usecases.CourseEvaluatorUseCase;


public class EvaluatorResponseModel {
    private String courseId;
    private int percentage;




    public EvaluatorResponseModel(String courseId, int percentage) {
        this.courseId = courseId;
        this.percentage = percentage;

    }

    public String getCourseId() {
        return courseId;
    }

    public int getPercentage(){
        return percentage;
    }






}
