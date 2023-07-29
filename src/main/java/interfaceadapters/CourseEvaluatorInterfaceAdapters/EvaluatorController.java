package interfaceadapters.CourseEvaluator;

import usecases.CourseEvaluator.EvaluatorInputBoundary;
import usecases.CourseEvaluator.EvaluatorRequestModel;

public class EvaluatorController {
    private final EvaluatorInputBoundary interactor;
    public EvaluatorController(EvaluatorInputBoundary interactor){
        this.interactor = interactor;}

    public String evaluateCourse() {
        return interactor.evaluate();
    }
}

