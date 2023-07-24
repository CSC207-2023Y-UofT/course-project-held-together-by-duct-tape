package courseEvaluator.UseCases;

import courseEvaluator.UseCases.EvaluatorResponseModel;

public interface EvaluatorSessionDataAccess {

    boolean CourseExists (String CourseID);

    EvaluatorResponseModel retrieveCourse(String courseId);
}
