package usecases.CourseEvaluator;

public interface EvaluatorSessionDataAccess {

    EvaluatorDbResponseModel retrieveCourse(EvaluatorRequestModel requestModel);

    String retrieveStudentId();
}
