package interfaceadapters.CourseEvaluatorInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.CourseEvaluatorUseCase.*;

public class EvaluatorPresenter implements EvaluatorOutputBoundary {
    private final EvaluatorController evaluatorController;

    public EvaluatorPresenter(Driver databaseDriver) {
        EvaluatorSessionDataAccess sessionDbGateway = databaseDriver.getSessionDbGateway();
        CourseDataAccess courseDbGateway = databaseDriver.getCourseDbGateway();
        StudentDataAccess studentDbGateway = databaseDriver.getStudentDbGateway();

        EvaluatorInteractor interactor = new EvaluatorInteractor(this, courseDbGateway, sessionDbGateway, studentDbGateway);
        evaluatorController = new EvaluatorController(interactor);
    }

    public EvaluatorController getEvaluatorController() {
        return evaluatorController;
    }

    @Override
    public String  prepareSuccessView(EvaluatorResponseModel grade) {
        return "You got " + grade.getPercentage() + "%" + " in " + grade.getCourseId();
    }

}
