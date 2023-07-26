package usecases.CourseEvaluator;

public interface EvaluatorSessionDataAccess {

    boolean CourseExists (String CourseID);

    EvaluatorDbResponseModel retrieveCourse(String courseId);

    String retrieveStudentId();
}
