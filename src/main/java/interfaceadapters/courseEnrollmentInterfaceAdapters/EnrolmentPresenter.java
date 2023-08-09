package interfaceadapters.courseEnrollmentInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.courseEnrollmentUseCase.*;

import java.util.List;

/**
 * Presenter for the enrollment use case. This class is responsible for: the enrollment success/fail messages, making
 * the call to the session gateway to delete the student/course from the session database, as well as making the call
 * to the course gateway to retrieve the names of the available courses.
 */
public class EnrolmentPresenter implements EnrolmentOutputBoundary {
    private final EnrolmentCourseDataAccess courseDbGateway;
    private final EnrolmentSessionDataAccess sessionDbGateway;
    private final EnrolmentController enrolmentController;

    /**
     * Initializes the presenter for the enrollment use case.
     * @param databaseDriver driver that connects the presenter to the databases
     */
    public EnrolmentPresenter(Driver databaseDriver) {
        this.courseDbGateway = databaseDriver.getCourseDbGateway();
        this.sessionDbGateway = databaseDriver.getSessionDbGateway();

        CheckPrerequisitesInteractor prerequisitesInteractor = new CheckPrerequisitesInteractor(sessionDbGateway);
        EnrolmentInputBoundary enrolmentInteractor = new CourseEnrolmentInteractor(courseDbGateway,
                prerequisitesInteractor, sessionDbGateway, this);

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
     * Throw error if student attempts to enroll in a course for which they have not completed the prerequisite.
     * @param failMessage message informing the student the reason for unsuccessful enrollment.
     * @return message signaling unsuccessful enrollment.
     */
    @Override
    public String prepareFailView(String failMessage) {
        throw new RuntimeException(failMessage);
    }

    /**
     * Calls the session gateway to delete the current course on the session database.
     */
    public void deleteCourseSession() {
        sessionDbGateway.deleteCourseSession();
    }

    /**
     * Calls the session gateway to delete the current user on the session database.
     */
    public void deleteStudentSession() {
        sessionDbGateway.deleteStudentSession();
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
