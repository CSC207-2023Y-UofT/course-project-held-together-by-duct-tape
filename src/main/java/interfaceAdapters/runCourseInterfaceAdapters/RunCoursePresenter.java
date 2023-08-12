package interfaceAdapters.runCourseInterfaceAdapters;

import frameworksDrivers.Driver;
import useCases.runCourseUseCase.RunCourseInputBoundary;
import useCases.runCourseUseCase.RunCourseInteractor;
import useCases.runCourseUseCase.RunCourseOutputBoundary;
import useCases.runCourseUseCase.RunCourseSessionDataAccess;

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
