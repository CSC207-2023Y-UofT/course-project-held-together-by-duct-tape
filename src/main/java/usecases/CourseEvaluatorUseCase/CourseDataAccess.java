package usecases.CourseEvaluator;

public interface CourseDataAccess {

    EvaluatorDbResponseModel findCourse(EvaluatorRequestModel requestModel);
}
