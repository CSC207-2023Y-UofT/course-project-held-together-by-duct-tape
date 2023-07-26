package usecases.CourseEvaluator;

public interface EvaluatorOutputBoundary {
    String prepareSuccessView(EvaluatorResponseModel grade);
    String prepareFailView();

}
