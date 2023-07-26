package interfaceadapters.CourseEvaluator;

import usecases.CourseEvaluator.EvaluatorOutputBoundary;
import usecases.CourseEvaluator.EvaluatorResponseModel;

public class EvaluatorPresenter implements EvaluatorOutputBoundary {

    @Override
    public String  prepareSuccessView(EvaluatorResponseModel grade) {
        return "You got " + grade.getPercentage() + "%" + " in " + grade.getCourseId();
    }

    @Override
    public String prepareFailView() {
        return "Not found in database";
    }


}
