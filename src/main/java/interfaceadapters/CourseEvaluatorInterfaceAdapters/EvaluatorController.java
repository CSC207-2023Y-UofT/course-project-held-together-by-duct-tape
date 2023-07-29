package interfaceadapters.CourseEvaluatorInterfaceAdapters;

import usecases.CourseEvaluatorUseCase.EvaluatorInputBoundary;

public class EvaluatorController {
    private final EvaluatorInputBoundary interactor;
    public EvaluatorController(EvaluatorInputBoundary interactor){
        this.interactor = interactor;}

    public String evaluateCourse() {
        return interactor.evaluate();
    }
}

