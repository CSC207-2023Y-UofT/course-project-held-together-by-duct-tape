package interfaceadapters.runCourseInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.runCourseUseCase.RunCourseInputBoundary;
import usecases.runCourseUseCase.RunCourseInteractor;
import usecases.runCourseUseCase.RunCourseOutputBoundary;
import usecases.runCourseUseCase.RunCourseSessionDataAccess;

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
