package usecases.courseEnrollmentUseCase;

import frameworksdriversmock.DatabaseDriverMock;
import interfaceadapters.courseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Test class for the course enrollment interactor. This tests whether a student is able to enrol successfully, i.e.,
 * if the course ID exists and the student has completed the prerequisites.
 */
public class CourseEnrolmentInteractorTest {
    public CourseEnrolmentInteractor enrolmentInteractor;

    /**
     * Initializes the interactor before each test.
     */
    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        EnrolmentPresenter enrolmentPresenter = new EnrolmentPresenter(databaseDriver);
        CheckPrerequisitesInteractor completedPrerequisites = new
                CheckPrerequisitesInteractor(databaseDriver.getSessionDbGatewayMock());

        this.enrolmentInteractor = new CourseEnrolmentInteractor(databaseDriver.getCourseDbGatewayMock(),
                completedPrerequisites, databaseDriver.getSessionDbGatewayMock(), enrolmentPresenter);

        databaseDriver.getCourseDbGatewayMock().addCourse("CSC148", "CSC108", 55,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        databaseDriver.getCourseDbGatewayMock().addCourse("CSC207", "CSC148", 50,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        databaseDriver.getCourseDbGatewayMock().addCourse("CSC263", "CSC236", 50,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Checks that exception is thrown if the student attempts to enrol in a nonexistent course.
     */
    @Test
    public void testNonexistentCourse() {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("ISP100");

        // If course ID does not exist in course database, a RuntimeException must be thrown.
        try {
            enrolmentInteractor.enrol(requestModel);
            Assertions.fail("This should not happen.");
        } catch (RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "Course ID does not exist in Database!");
        }
    }

    /**
     * Checks that exception is thrown if the student attempts to enrol in a course for which they do not have
     * the minimum GPA for the required prerequisite.
     */
    @Test
    public void testInsufficientGPAPrerequisite() {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("CSC207");

        // If the student has not attained the minimum required grade for the prerequisite,
        // a RuntimeException must be thrown.
        try {
            enrolmentInteractor.enrol(requestModel);
            Assertions.fail("This should not happen.");
        } catch (RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "You have not completed the prerequisites " +
                    "for the course.\nPrerequisite: CSC148 Grade: 50.0");
        }
    }

    /**
     * Checks that exception is thrown if the student attempts to enrol in a course without having completed the
     * prerequisite for that course.
     */
    @Test
    public void testUncompletedCoursePrerequisite() {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("CSC263");

        // If the student has not completed the prerequisite course, a RuntimeException must be thrown.
        try {
            enrolmentInteractor.enrol(requestModel);
            Assertions.fail("This should not happen.");
        } catch (RuntimeException e) {
            Assertions.assertEquals(e.getMessage(), "You have not completed the prerequisites " +
                    "for the course.\nPrerequisite: CSC236 Grade: 50.0");
        }
    }

    /**
     * Checks that a student who has completed the prerequisites for the requested course is able to enrol.
     */
    @Test
    public void testSuccessfulEnrollment() {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("CSC148");

        // If the student has the prerequisites for the course, display success message.
        Assertions.assertEquals("You've successfully enrolled in course CSC148",
                enrolmentInteractor.enrol(requestModel));

    }
}