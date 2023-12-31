package interfaceAdapters.courseEnrollmentInterfaceAdapters;

import frameworksDriversMock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.courseEnrollmentUseCase.CheckPrerequisitesInteractor;
import useCases.courseEnrollmentUseCase.CourseEnrolmentInteractor;
import useCases.courseEnrollmentUseCase.EnrolmentInputBoundary;
import java.util.ArrayList;

/**
 * Test class for the course enrollment controller. This tests the creation of a request model and the call made
 * to the interactor.
 */
class EnrolmentControllerTest {
    private EnrolmentController enrolmentController;
    /**
     * Initializes the controller before each test.
     */
    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        EnrolmentPresenter enrolmentPresenter = new EnrolmentPresenter(databaseDriver);
        CheckPrerequisitesInteractor completedPrerequisites = new
                CheckPrerequisitesInteractor(databaseDriver.getSessionDbGatewayMock());

        EnrolmentInputBoundary enrolmentInteractor = new CourseEnrolmentInteractor(databaseDriver.getCourseDbGatewayMock(),
                completedPrerequisites, databaseDriver.getSessionDbGatewayMock(), enrolmentPresenter);
        this.enrolmentController = new EnrolmentController(enrolmentInteractor);

        databaseDriver.getCourseDbGatewayMock().addCourse("CSC207", "CSC148", 50,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Tests whether the request model was created correctly, in order for it to be used by the interactor.
     */
    @Test
    public void testSuccessEnroll() {
        // Enrollment is successful
        Assertions.assertEquals("You've successfully enrolled in course CSC108",
                enrolmentController.enrol("CSC108"));
    }

    @Test
    public void testFailureNotMetPrerequisites() {
        // Enrollment is unsuccessful, because student does not have the prerequisites.
        try {
            enrolmentController.enrol("CSC207");
        } catch (EnrolmentFailure e) {
            Assertions.assertEquals(e.getMessage(), "You have not completed the prerequisites " +
                    "for the course.\nPrerequisite: CSC148 Grade: 50.0");
        }
    }

    @Test
    public void testFailureCourseNotExist() {
        // Enrollment is unsuccessful, because course ID does not exist in database.
        try {
            enrolmentController.enrol("CSC1110");
        } catch (EnrolmentFailure e) {
            Assertions.assertEquals(e.getMessage(), "Course ID does not exist in Database!");
        }
    }
}
