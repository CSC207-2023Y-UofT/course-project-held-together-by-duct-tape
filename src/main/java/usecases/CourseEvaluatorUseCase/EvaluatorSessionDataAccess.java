package usecases.CourseEvaluatorUseCase;

public interface EvaluatorSessionDataAccess {
    EvaluatorDbResponseModel retrieveCourse();
    void retrieveUser(EvaluatorDbRequestModel requestModel);
}
