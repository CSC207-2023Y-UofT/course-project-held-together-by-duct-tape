package usecases.CourseEvaluatorUseCase;

public interface EvaluatorSessionDataAccess {
    EvaluatorDbResponseModel retrieveCourse();
    String retrieveStudentId();
}
