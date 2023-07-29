package interfaceadapters.CourseEvaluator;

import entities.CourseFactory;
import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.Driver;
import frameworksdrivers.SessionDbGateway;
import frameworksdrivers.StudentDbGateway;
import usecases.CourseEvaluator.*;

public class EvaluatorPresenter implements EvaluatorOutputBoundary {
    private final EvaluatorSessionDataAccess sessionDbGateway;
    private final CourseDataAccess courseDbGateway;
    private final StudentDataAccess studentDbGateway;
    private final EvaluatorController evaluatorController;

    public EvaluatorPresenter(Driver databaseDriver) {
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();
        this.courseDbGateway = databaseDriver.getCourseDbGateway();
        this.studentDbGateway = databaseDriver.getStudentDbGateway();

        CourseFactory courseFactory = new CourseFactory();
        CheckAnswer checkAnswer = new CheckAnswer();
        EvaluatorInteractor interactor = new EvaluatorInteractor(this, courseDbGateway, sessionDbGateway, courseFactory, studentDbGateway, checkAnswer);
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
