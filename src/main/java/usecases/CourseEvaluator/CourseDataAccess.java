package usecases.CourseEvaluator;

public interface CourseDataAccess {

    EvaluatorDbResponseModel findCourse(String courseId);
}
