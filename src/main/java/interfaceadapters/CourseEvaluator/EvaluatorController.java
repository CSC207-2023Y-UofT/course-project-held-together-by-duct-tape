package interfaceadapters.CourseEvaluator;

import usecases.CourseEvaluator.EvaluatorInputBoundary;
import usecases.CourseEvaluator.EvaluatorRequestModel;

public class EvaluatorController {
        private EvaluatorInputBoundary interactor;
        public EvaluatorController(EvaluatorInputBoundary interactor){
            this.interactor = interactor;}

        public String evaluateCourse (String courseId) {
            EvaluatorRequestModel requestModel = new EvaluatorRequestModel(courseId);
            return interactor.evaluate(requestModel);
        }
}

