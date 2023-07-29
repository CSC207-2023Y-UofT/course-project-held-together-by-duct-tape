package interfaceadapters.CourseEvaluatorInterfaceAdapters;

import usecases.CourseEvaluatorUseCase.EvaluatorInputBoundary;
import usecases.CourseEvaluatorUseCase.EvaluatorRequestModel;

public class EvaluatorController {
        private EvaluatorInputBoundary interactor;
        public EvaluatorController(EvaluatorInputBoundary interactor){
            this.interactor = interactor;}

        public String evaluateCourse (String courseId) {
            EvaluatorRequestModel requestModel = new EvaluatorRequestModel(courseId);
            return interactor.evaluate(requestModel);
        }
}

