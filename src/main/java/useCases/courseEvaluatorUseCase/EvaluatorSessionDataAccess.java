package useCases.courseEvaluatorUseCase;

public interface EvaluatorSessionDataAccess {
    EvaluatorDbResponseModel retrieveCourse();
    void retrieveUser(EvaluatorDbRequestModel requestModel);
}
