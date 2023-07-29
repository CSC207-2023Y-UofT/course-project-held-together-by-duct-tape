package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.CourseEnrollmentUseCase.*;

import java.util.List;

public class EnrolmentPresenter implements EnrolmentOutputBoundary {
    private final EnrolmentCourseDataAccess courseDbGateway;
    private final EnrolmentSessionDataAccess sessionDbGateway;
    private final EnrolmentController enrolmentController;

    public EnrolmentPresenter(Driver databaseDriver) {
        this.courseDbGateway = databaseDriver.getCourseDbGateway();
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();

        CheckPrerequisitesInteractor prerequisitesInteractor = new CheckPrerequisitesInteractor(sessionDbGateway);
        CourseEnrolmentInteractor enrolmentInteractor = new CourseEnrolmentInteractor(courseDbGateway, prerequisitesInteractor, sessionDbGateway, this);

        enrolmentController = new EnrolmentController(enrolmentInteractor);
    }

    public EnrolmentController getEnrolmentController() {
        return enrolmentController;
    }

    /**
     * Prepares a success view signaling successful enrollment.
     * @param course data structure containing the courseId and the questions for the course in which the student
     * has enrolled.
     * @return message indicating successful enrollment.
     */
    @Override
    public String prepareSuccessView(EnrolmentResponseModel course) {
        return "You've successfully enrolled in course " + course.getCourseId();
    }

    /**
     * Throw error if student attempts to enroll in a nonexistent course, or a course for which they have not completed
     * the prerequisite.
     * @param failMessage message informing the student the reason for unsuccessful enrollment.
     * @return message signaling unsuccessful enrollment.
     */
    @Override
    public String prepareFailView(String failMessage) {
        throw new RuntimeException(failMessage);
    }

    public void deleteCourseSession() {
        sessionDbGateway.deleteCourseSession();
    }

    /**
     * Get a list of the course IDs offered. This method will call the course gateway to access the database to
     * retrieve the course IDs.
     *
     * @return List of Strings with the course IDs.
     */
    public List<String> getCourseIDs() {
        return courseDbGateway.getCourseIDs();
    }
}
