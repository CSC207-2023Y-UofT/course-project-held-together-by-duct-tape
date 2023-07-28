package interfaceadapters.RunCourseInterfaceAdapters;

import frameworksdrivers.DatabaseDriver;
import frameworksdrivers.SessionDbGateway;

import java.util.List;

public class RunCoursePresenter {
    private final SessionDbGateway sessionDbGateway;
    private final RunCourseController courseController;

    public RunCoursePresenter(DatabaseDriver databaseDriver) {
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();
        courseController = new RunCourseController();
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
}
