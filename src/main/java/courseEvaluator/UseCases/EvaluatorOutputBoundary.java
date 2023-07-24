package courseEvaluator.UseCases;

public interface EvaluatorOutputBoundary {
    EvaluatorResponseModel prepareSuccessView(EvaluatorResponseModel grade); //change to string??
    EvaluatorResponseModel prepareFailView(String failMessage);

}
