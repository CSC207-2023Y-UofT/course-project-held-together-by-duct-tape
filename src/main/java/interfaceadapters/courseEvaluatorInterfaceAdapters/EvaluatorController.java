package interfaceadapters.courseEvaluatorInterfaceAdapters;

import usecases.courseEvaluatorUseCase.EvaluatorInputBoundary;

public class EvaluatorController {
    private final EvaluatorInputBoundary interactor;

    public EvaluatorController(EvaluatorInputBoundary interactor){
        this.interactor = interactor;
    }

    public String evaluateCourse() {
        return interactor.evaluate();
    }
}

