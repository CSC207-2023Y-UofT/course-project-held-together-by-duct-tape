package interfaceadapters.RunCourseInterfaceAdapters;

import frameworksdrivers.Driver;
import frameworksdrivers.Gateways.SessionDbGateway;
import usecases.RunCourseUseCase.RunCourseInteractor;
import usecases.RunCourseUseCase.RunCourseOutputBoundary;
import usecases.RunCourseUseCase.RunCourseSessionDataAccess;

import java.util.List;

public class RunCoursePresenter implements RunCourseOutputBoundary{
    private final SessionDbGateway sessionDbGateway;
    private final RunCourseController courseController;

    public RunCoursePresenter(Driver databaseDriver) {
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();
        RunCourseInteractor interactor = new RunCourseInteractor((RunCourseSessionDataAccess) sessionDbGateway, (RunCourseOutputBoundary) this);
        courseController = new RunCourseController(interactor);
    }

    public RunCourseController getCourseController() {
        return courseController;
    }

    public List<String> getCourseQuestions() {
        return sessionDbGateway.getCourseQuestions();
    }

    public void deleteCourseSession() {
        sessionDbGateway.deleteCourseSession();
    }

    @Override
    public String failView(String message) {
        return message;
    }

    @Override
    public String successView(String message) {
        return message;
    }
}
