package usecases.courseEvaluatorUseCase;

public interface EvaluatorSessionDataAccess {
    EvaluatorDbResponseModel retrieveCourse();
    void retrieveUser(EvaluatorDbRequestModel requestModel);
}
