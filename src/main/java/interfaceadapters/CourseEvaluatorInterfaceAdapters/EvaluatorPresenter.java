package interfaceadapters.CourseEvaluatorInterfaceAdapters;

import usecases.CourseEvaluatorUseCase.EvaluatorOutputBoundary;
import usecases.CourseEvaluatorUseCase.EvaluatorResponseModel;

public class EvaluatorPresenter implements EvaluatorOutputBoundary {

    @Override
    public String  prepareSuccessView(EvaluatorResponseModel grade) {
        return "You got " + grade.getPercentage() + "%" + " in " + grade.getCourseId();
    }




}
