package usecases.CourseEvaluatorUseCase;

public interface CourseDataAccess {

    EvaluatorDbResponseModel findCourse(EvaluatorRequestModel requestModel);
}
