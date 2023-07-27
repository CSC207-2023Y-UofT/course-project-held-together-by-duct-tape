package usecases.CourseEvaluator;

public interface EvaluatorSessionDataAccess {

    boolean courseExists (String courseID);

    EvaluatorDbResponseModel retrieveCourse(String courseId);

    String retrieveStudentId();
}
