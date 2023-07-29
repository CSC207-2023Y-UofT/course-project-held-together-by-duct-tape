package interfaceadapters.RunCourseInterfaceAdapters;

import frameworksdrivers.Driver;
import frameworksdrivers.Gateways.SessionDbGateway;
import frameworksdrivers.Gateways.SessionGateway;
import usecases.RunCourseUseCase.RunCourseInputBoundary;
import usecases.RunCourseUseCase.RunCourseInteractor;
import usecases.RunCourseUseCase.RunCourseOutputBoundary;
import usecases.RunCourseUseCase.RunCourseSessionDataAccess;

import java.util.List;

public class RunCoursePresenter implements RunCourseOutputBoundary{
    private final RunCourseSessionDataAccess sessionDbGateway;
    private final RunCourseController courseController;

    public RunCoursePresenter(Driver databaseDriver) {
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();
        RunCourseInputBoundary interactor = new RunCourseInteractor(sessionDbGateway, this);
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
