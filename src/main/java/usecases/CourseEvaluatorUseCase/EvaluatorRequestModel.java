package usecases.CourseEvaluatorUseCase;

public class EvaluatorRequestModel {

    private final String courseId;

    public EvaluatorRequestModel(String courseId) {
        this.courseId = courseId;

    }


    public String getCourseId() {
        return courseId;
    }

}


